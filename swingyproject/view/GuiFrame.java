package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controler.Main;
import utilities.CreateHero;
import utilities.Map;
import utilities.characters.Hero;
import view.LoadSavedData;

public class GuiFrame extends JFrame {
    private Map map;
    private Hero hero;
    private Gui gui;
    private StartGame startGame;
    private CreateHero createHero;
    private LoadSavedData loadCharacter;
    private SwitchView switchView;
    
    public GuiFrame(){
        
        initialiseView();
    }

    public GuiFrame(Map map, Hero hero){

        this.map = map;
        this.hero = hero;
        
        initialiseView();
    }

    public void initialiseView()
    {
        this.addPropertyChangeListener(new MainMenuListener());

        gui = new Gui();
        gui.addPropertyChangeListener(new MainMenuListener());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setResizable(false);
        this.add(gui);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private class MainMenuListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source.equals("StartGame")) {
                if (hero == null) {
                    JOptionPane.showMessageDialog(null, "No Hero Selected.",
                            "WARNING", JOptionPane.ERROR_MESSAGE);
                } else {
                    removeMainMenu();
                    newStartGame();
                }
            } else if (source.equals("Continue")) {
                removeMainMenu();
                newCreateHero();
            } else if (source.equals("Change Display")) {
                removeMainMenu();
                newLoadCharacter();
            } else if (source.equals("Exit")) {
                System.exit(0);
            }
        }
    }

    private class StartGameListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source == "MainMenu") {
                removeStartGame();
                newMainMenu();
            } else if (source == "HeroAttributes") {
                displayHeroAttributes();
            } else if (source == "Help") {
                displayHelp();
            } else if (source.equals("Defeat")) {
                removeStartGame();
                newMainMenu();
            } else if (source.equals("Victory")) {
                JOptionPane.showMessageDialog(null, "You have successfully"
                        + " defeated all levels.\nCongratulations! You, "
                        + hero.getPlayerName() + ", have ascended to LEGENDARY"
                        + " status!\n", "GAME WON!",
                        JOptionPane.INFORMATION_MESSAGE);
                hero = startGame.getHero();
                removeStartGame();
                newMainMenu();
            }
        }
    }

    public class CreateHeroListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source == "Default") {
                JOptionPane.showMessageDialog(null, "No Class Selected.",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "Load") {
                createHero();
                JOptionPane.showMessageDialog(null, "Hero '"
                        + hero.getPlayerName() + "' Created.", "CREATED",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (source == "nullName") {
                JOptionPane.showMessageDialog(null, "No Name Entered.",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "nullType") {
                JOptionPane.showMessageDialog(null, "No Class Selected.",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "Back") {
                removeCreateHero();
                newMainMenu();
            }
        }
    }

    private class LoadCharacterListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source == "Load") {
                loadHero();
                JOptionPane.showMessageDialog(null, "Hero '"
                        + hero.getPlayerName() + "' selected.", "LOADED",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (source == "Default") {
                JOptionPane.showMessageDialog(null, "No Hero Selected.",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "NoFile") {
                JOptionPane.showMessageDialog(null, "No Saved Files Detected.",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "Back") {
                removeLoadCharacter();
                newMainMenu();
            }
        }
    }

    private class SwitchViewListener implements PropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            String source = pce.getPropertyName();
            if (source == "Back") {
                removeSwitchView();
                newMainMenu();
            } else if (source == "ConsoleView") {
                Main.setMap(map);
                Main.setHero(hero);
                Main.closeGui();
            }
            SwitchViewFrame view = new SwitchViewFrame();
            view.initialiseView();
        }
    }

    private void newMainMenu() {
        gui = new Gui();
        gui.addPropertyChangeListener(new MainMenuListener());

        add(gui);
        pack();
    }

    private void removeMainMenu() {
        remove(gui);
        gui = null;
    }

    private void newStartGame() {
        startGame = new StartGame(hero);
        startGame.addPropertyChangeListener(new StartGameListener());

        add(startGame);
        pack();
    }

    private void removeStartGame() {
        remove(startGame);
        startGame = null;
    }

    private void newCreateHero() {
        createHero = new CreateHero();
        createHero.addPropertyChangeListener(new CreateHeroListener());

        add(createHero);
        pack();
    }

    private void removeCreateHero() {
        remove(createHero);
        createHero = null;
    }

    private void newLoadCharacter() {
        loadCharacter = new LoadSavedData();
        loadCharacter.addPropertyChangeListener(new LoadCharacterListener());

        this.add(loadCharacter);
        this.pack();
    }

    private void removeLoadCharacter() {
        this.remove(loadCharacter);
        loadCharacter = null;
    }

    private void newSwitchView() {
        switchView = new SwitchView();
        switchView.addPropertyChangeListener(new SwitchViewListener());

        add(switchView);
        pack();
    }

    private void removeSwitchView() {
        remove(switchView);
        switchView = null;
    }

    public void displayHeroAttributes() {
        if (hero != null) {
            JOptionPane.showMessageDialog(null,
                    "Hero Attributes\n"
                    + "- - - - - - - - -\n"
                    + "Name:   " + hero.getPlayerName() + "\n"
                    + "Class:  " + hero.getType() + "\n"
                    + "Level:  " + hero.getLevel() + "\n"
                    + "EXP:    " + hero.getExperience() + "\n"
                    + "ATT:    " + hero.getAttack() + "\n"
                    + "DEF:    " + hero.getDefense() + "\n"
                    + "HP:     " + hero.getHitPoints() + "\n\n"
                    + "Hero Artifacts\n"
                    + "- - - - - - - -\n"
                    + "Helmet: " + hero.getHelmet().getHitPoints() + " HP\n"
                    + "Armor:  " + hero.getArmor().getDefense() + " DEF\n"
                    + "Weapon: " + hero.getWeapon().getAttack() + " ATT\n",
                    "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayHelp() {
        if (hero != null) {
            JOptionPane.showMessageDialog(null,
                    "Controls\n"
                    + "- - - - -\n"
                    + "North -  Up\n"
                    + "West  -  Left\n"
                    + "South -  Down\n"
                    + "East  -  Right\n\n"
                    + "Map Key\n"
                    + "- - - - -\n"
                    + "o     -  Hero\n"
                    + "x     -  Villain\n"
                    + ".     -  Empty\n",
                    "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void loadHero() {
        Hero temp = LoadSavedData.getHero();
        if (temp != null) {
            hero = temp;
            map = new Map(hero);
        }
    }

    private void createHero() {
        Hero temp = CreateHero.getHero();
        if (temp != null) {
            hero = temp;
            map = new Map(hero);
        }
    }

    public void restartGame() {
        removeStartGame();
        newMainMenu();
    }

    public void closeFrame() {
        this.dispose();
        this.setVisible(false);
        
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
