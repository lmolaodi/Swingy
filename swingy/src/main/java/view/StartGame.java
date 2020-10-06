package view;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import swingy.App;
import utilities.Battle;
import utilities.Map;
import utilities.SelectArtifact;
import utilities.characters.Hero;
import utilities.vault.Armor;
import utilities.vault.Helm;
import utilities.vault.Weapon;
import utilities.characters.PlayerCharacter;

public class StartGame extends JPanel {

    private Hero hero;
    private Map map;
    private static Armor tempArmor = null;
    private static Helm tempHelm = null;
    private static Weapon tempWeapon = null;
    private Random rand;
    private JDialog dialogWindow;
    private boolean victory = false;

    /**
     * Creates new form StartGame
     */
    public Hero getHero() {
        return hero;
    }

    public Map getMap() {
        return map;
    }

    public static void setHelm(Helm helm) {
        tempHelm = helm;
    }

    public static void setArmor(Armor armor) {
        tempArmor = armor;
    }

    public static void setWeapon(Weapon weapon) {
        tempWeapon = weapon;
    }

    private void displayMap() {
        mapDisplayArea.setText(null);
        for (int y = 0; y < map.getSize(); ++y) {
            for (int x = 0; x < map.getSize(); ++x) {
                if (hero.getX() == x && hero.getY() == y) {
                    if (x == 0) {
                        mapDisplayArea.append("o ");
                    } else if (x == map.getSize() - 1) {
                        mapDisplayArea.append(" o");
                    } else {
                        mapDisplayArea.append(" o ");
                    }
                    continue;
                }
                mapDisplayArea.append(map.getCharacter(y, x).getPlayerName());
            }
            mapDisplayArea.append("\n");
        }
    }

    public void battle() {

        victory = true;

        if (map.getCharacter(hero.getY(), hero.getX()).getClass().getSimpleName().equals("Villain")) {

            dialogWindow = new JDialog();
            Battle battlePanel = new Battle();

            battlePanel.addPropertyChangeListener(new BattleListener());
            dialogWindow.setTitle("Villain Encountered");
            dialogWindow.setModal(true);
            dialogWindow.setContentPane(battlePanel);
            dialogWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialogWindow.pack();
            dialogWindow.setLocationRelativeTo(null);
            dialogWindow.setVisible(true);
        }
    }

    private class BattleListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source.equals("Fight")) {

                if (!battleFight(hero, map.getCharacter(hero.getY(), hero.getX()))) {

                    dialogWindow.dispose();
                    JOptionPane.showMessageDialog(null, "Game Over!", "defeated", JOptionPane.ERROR_MESSAGE);
                    victory = false;

                } else {
                    victory = true;
                    dialogWindow.dispose();
                    JOptionPane.showMessageDialog(null, "You are victorious!", "VICTORY",
                            JOptionPane.INFORMATION_MESSAGE);
                    hero.increaseExperience();
                    dropArtifact();
                    map.removeVillain();
                }
            } else if (source.equals("Run")) {
                battleRun();
            } else if (source.equals("Help")) {
                JOptionPane.showMessageDialog(null, "help pressed!..");
            }
        }
    }

    public boolean battleFight(Hero hero, utilities.characters.PlayerCharacter character) {
        int attack;
        int heroHitPoints = hero.getHitPoints();
        int villainHitPoints = character.getHitPoints();

        System.out.println("\nHero     | Villain");
        System.out.println("--------------------");
        System.out.println("HP : " + hero.getHitPoints() + " | " + character.getHitPoints());
        System.out.println("DEF:  " + hero.getDefense() + " | " + character.getDefense());
        System.out.println("ATT:  " + hero.getAttack() + " | " + character.getAttack());

        while (heroHitPoints > 0 && villainHitPoints > 0) {
            // hero's attack damage on villain
            attack = hero.getAttack() / ((rand.nextInt(5) + 1));
            if ((villainHitPoints -= attack) <= 0) {
                victory = true;
                return true;
            }

            // villain's attack damage on hero
            attack = character.getAttack() / ((rand.nextInt(5) + 1));
            if ((rand.nextInt(20) + 1) == 1) {
                attack *= 1.5;
            }

            if ((heroHitPoints -= attack) <= 0) {
                victory = false;
                return false;
            }
        }
        victory = true;
        return true;
    }

    private void battleRun() {
        int outcome = rand.nextInt(5) + 1;
        if (outcome != 1 && outcome != 2) {
            dialogWindow.dispose();
            dialogWindow = null;
            JOptionPane.showMessageDialog(null, "You successfulyl evaded the" + " battle!", "VICTORY",
                    JOptionPane.INFORMATION_MESSAGE);
            hero.setCharacterPosition(hero.getPreviousX(), hero.getPreviousY());
            displayMap();
        } else {
            dialogWindow.dispose();
            dialogWindow = null;
            JOptionPane.showMessageDialog(null, "You were unable to evade" + " the battle.\nPrepare to fight!",
                    "UNLUCKY", JOptionPane.ERROR_MESSAGE);
            if (!battleFight(hero, map.getCharacter(hero.getY(), hero.getX()))) {
                JOptionPane.showMessageDialog(null, "Game Over!", "DEFEAT", JOptionPane.ERROR_MESSAGE);
                victory = false;
                System.exit(0);
            } else {
                victory = true;
                JOptionPane.showMessageDialog(null, "You are victorious!", "VICTORY", JOptionPane.INFORMATION_MESSAGE);
                hero.increaseExperience();
                dropArtifact();
                map.removeVillain();
            }
        }
    }

    private void dropArtifact() {
        int dropChance = rand.nextInt(6) + 1;

        if (dropChance == 1 || dropChance == 2 || dropChance == 3) {
            Armor armor = new Armor(hero);
            Helm helm = new Helm(hero);
            Weapon weapon = new Weapon(hero);

            dialogWindow = new JDialog();
            SelectArtifact panel = new SelectArtifact(map, hero);

            panel.addPropertyChangeListener(new ArtifactListener());
            dialogWindow.setTitle("Artifact Dropped.");
            dialogWindow.setModal(true);
            dialogWindow.setContentPane(panel);
            dialogWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialogWindow.pack();
            dialogWindow.setLocationRelativeTo(null);
            dialogWindow.setVisible(true);

        }
    }

    private class ArtifactListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source.equals("Equip")) {
                if (tempHelm != null) {
                    hero.newHelm(tempHelm);
                    tempHelm = null;
                    tempArmor = null;
                    tempWeapon = null;
                } else if (tempArmor != null) {
                    hero.newArmor(tempArmor);
                    tempHelm = null;
                    tempArmor = null;
                    tempWeapon = null;
                } else if (tempWeapon != null) {
                    hero.newWeapon(tempWeapon);
                    tempHelm = null;
                    tempArmor = null;
                    tempWeapon = null;
                }
                dialogWindow.dispose();
            } else if (source.equals("Decline")) {
                dialogWindow.dispose();
            }
        }
    }

    public void victory() {
        victory = false;
        if ((hero.getX() == 0) || (hero.getX() == (map.getSize() - 1)) || (hero.getY() == 0)
                || (hero.getY() == (map.getSize() - 1))) {
            // System.out.println("Level Complete!\n");
            if (checkHeroLevel()) {
                victory = true;
            } else {
                hero.levelUp();
                map = new Map(hero);
                displayMap();
            }
        }
    }

    private boolean checkHeroLevel() {
        return this.hero.getLevel() >= this.hero.getMAX_LEVEL();
    }

    public StartGame(Hero hero) {
        initiateStart();

        this.map = new Map(hero);
        this.hero = hero;
        rand = new Random();
        displayMap();
    }

    public StartGame() {
        initiateStart();
    }

    public void initiateStart() {

        mapScrollPane = new javax.swing.JScrollPane();
        mapDisplayArea = new javax.swing.JTextArea();
        heroStatsDisplay = new javax.swing.JTextArea();
        northButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        westButton = new javax.swing.JButton();
        eastButton = new javax.swing.JButton();
        southButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        heroAttributesButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        mapDisplayArea.setColumns(20);
        mapDisplayArea.setFont(new java.awt.Font("Courier", 0, 13));
        mapDisplayArea.setRows(5);
        mapScrollPane.setViewportView(mapDisplayArea);

        heroStatsDisplay.setColumns(20);
        heroStatsDisplay.setFont(new java.awt.Font("Courier", 0, 13));
        heroStatsDisplay.setRows(5);
        heroStatsDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveButton.setFont(new java.awt.Font("Courier", 0, 13));
        saveButton.setText("Save Game");
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setMaximumSize(new java.awt.Dimension(165, 30));
        saveButton.setMinimumSize(new java.awt.Dimension(165, 30));
        saveButton.setPreferredSize(new java.awt.Dimension(165, 30));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (evt.getSource() == saveButton) {
                    ArrayList<String> list;
                    try {
                        String textFile = hero.getPlayerName() + "_" + hero.getType() + "_" + hero.getLevel() + "_"
                                + hero.getExperience() + ".txt";

                        String fileName = System.getProperty("user.dir") + "/swingy/src/main/java/saves/" + textFile;
                        PrintWriter file = new PrintWriter(fileName);
                        list = hero.saveAttributes();
                        for (String str : list) {
                            file.println(str);
                        }
                        file.close();
                        JOptionPane.showMessageDialog(null, "Game Saved!..");
                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(null, "Can not save file");
                        ;
                    }
                }
            }
        });

        northButton.setFont(new java.awt.Font("Courier", 0, 13));
        northButton.setText("North");
        northButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        northButton.setMaximumSize(new java.awt.Dimension(165, 30));
        northButton.setMinimumSize(new java.awt.Dimension(165, 30));
        northButton.setPreferredSize(new java.awt.Dimension(165, 30));
        northButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (hero.getY() != 0) {
                    hero.setPreviousPosition(hero.getX(), hero.getY());
                    hero.setY(hero.getY() - 1);
                    displayMap();
                }
                battle();
                if (victory == false) {
                    JOptionPane.showMessageDialog(null, "Try again next time!..");
                    System.exit(0);
                }
                if (victory == true) {
                    victory();
                    if (victory == true) {
                        // JOptionPane.showMessageDialog(null, "Victory! continuing!!..");
                    }
                }
            }
        });

        westButton.setFont(new java.awt.Font("Courier", 0, 13));
        westButton.setText("West");
        westButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        westButton.setMaximumSize(new java.awt.Dimension(165, 30));
        westButton.setMinimumSize(new java.awt.Dimension(165, 30));
        westButton.setPreferredSize(new java.awt.Dimension(165, 30));
        westButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (hero.getX() != 0) {
                    hero.setPreviousPosition(hero.getX(), hero.getY());
                    hero.setX(hero.getX() - 1);
                    displayMap();
                }
                battle();
                if (victory == false) {
                    JOptionPane.showMessageDialog(null, "Try again next time!..");
                    System.exit(0);
                }
                if (victory == true) {
                    victory();
                    if (victory == true) {
                        // JOptionPane.showMessageDialog(null, "Victory!");
                    }
                }
            }
        });

        eastButton.setFont(new java.awt.Font("Courier", 0, 13));
        eastButton.setText("East");
        eastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eastButton.setMaximumSize(new java.awt.Dimension(60, 50));
        eastButton.setMinimumSize(new java.awt.Dimension(60, 50));
        eastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (hero.getX() != hero.getMapLimit() - 1) {
                    hero.setPreviousPosition(hero.getX(), hero.getY());
                    hero.setX(hero.getX() + 1);
                    displayMap();
                }
                battle();
                if (victory == false) {
                    JOptionPane.showMessageDialog(null, "Try again next time!..");
                    System.exit(0);
                }
                if (victory == true) {
                    victory();
                    if (victory == true) {
                        // firePropertyChange("Victory", null, evt);
                    }
                }
            }
        });

        southButton.setFont(new java.awt.Font("Courier", 0, 13));
        southButton.setText("South");
        southButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        southButton.setPreferredSize(new java.awt.Dimension(60, 50));
        southButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (hero.getY() != hero.getMapLimit() - 1) {
                    hero.setPreviousPosition(hero.getX(), hero.getY());
                    hero.setY(hero.getY() + 1);
                    displayMap();
                }
                battle();
                if (victory == false) {
                    JOptionPane.showMessageDialog(null, "Try again next time!..");
                    System.exit(0);
                }
                if (victory == true) {
                    victory();
                    if (victory == true) {
                        // firePropertyChange("Victory", null, evt);
                    }
                }
            }
        });

        mainMenuButton.setFont(new java.awt.Font("Courier", 0, 13));
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setMaximumSize(new java.awt.Dimension(165, 30));
        mainMenuButton.setMinimumSize(new java.awt.Dimension(165, 30));
        mainMenuButton.setPreferredSize(new java.awt.Dimension(165, 30));
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                App.changeViewGui();
            }
        });

        heroAttributesButton.setFont(new java.awt.Font("Courier", 0, 13));
        heroAttributesButton.setText("Hero Attributes");
        heroAttributesButton.setMaximumSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.setMinimumSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.setPreferredSize(new java.awt.Dimension(165, 30));
        heroAttributesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource() == heroAttributesButton) {
                    if (hero != null) {
                        JOptionPane.showMessageDialog(null, "Hero Attributes\n" + "- - - - - - - - -\n" + "Name:   "
                                + hero.getPlayerName() + "\n" + "Class:  " + hero.getType() + "\n" + "Level:  "
                                + hero.getLevel() + "\n" + "EXP:    " + hero.getExperience() + "\n" + "ATT:    "
                                + hero.getAttack() + "\n" + "DEF:    " + hero.getDefense() + "\n" + "HP:     "
                                + hero.getHitPoints() + "\n\n" + "Hero Artifacts\n" + "- - - - - - - -\n" + "Helmet: "
                                + hero.getHelmet().getHitPoints() + " HP\n" + "Armor:  " + hero.getArmor().getDefense()
                                + " DEF\n" + "Weapon: " + hero.getWeapon().getAttack() + " ATT\n", "Help",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        helpButton.setFont(new java.awt.Font("Courier", 0, 13));
        helpButton.setText("Help");
        helpButton.setPreferredSize(new java.awt.Dimension(165, 30));
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mapScrollPane)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(heroAttributesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35).addComponent(helpButton,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(heroStatsDisplay, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addGap(128, 128, 128)
                                        .addComponent(westButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(northButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(southButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(90, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(heroAttributesButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(heroStatsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(
                                                northButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup().addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(westButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(eastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(southButton,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)));
    }

    protected void helpButtonActionPerformed(ActionEvent evt) {
        if (evt.getSource() == helpButton) {
            if (hero != null) {
                JOptionPane.showMessageDialog(null,
                        "Controls\n" + "- - - - -\n" + "North -  Up\n" + "West  -  Left\n" + "South -  Down\n"
                                + "East  -  Right\n\n" + "Map Key\n" + "- - - - -\n" + "o     -  Hero\n"
                                + "x     -  Villain\n" + ".     -  Empty\n",
                        "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private javax.swing.JButton eastButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton heroAttributesButton;
    private javax.swing.JTextArea heroStatsDisplay;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JTextArea mapDisplayArea;
    private javax.swing.JScrollPane mapScrollPane;
    private javax.swing.JButton northButton;
    private javax.swing.JButton southButton;
    private javax.swing.JButton westButton;

}