package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.App;
import model.CreateHero;
import model.Map;
import model.characters.Hero;

public class GuiFrame extends JFrame {
    private Map map;
    private Hero hero;
    private Gui gui;
    private StartGame startGame;
    private CreateHero createHero;
    private LoadSavedData loadCharacter;
    private SwitchView switchView;

    public GuiFrame() {

        initialiseView();
    }

    public GuiFrame(Map map, Hero hero) {

        this.map = map;
        this.hero = hero;

        initialiseView();
    }

    public void initialiseView() {
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
            if (source.equals("Start Game")) {
                if (hero == null) {
                    removeMainMenu();
                    newCreateHero();
                } else {
                    removeMainMenu();
                    newStartGame();
                }
            } else if (source.equals("Continue")) {
                removeMainMenu();
                newLoadCharacter();
            } else if (source.equals("Change Display")) {
                removeMainMenu();
                newSwitchView();
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
                JOptionPane.showMessageDialog(null,
                        "You have successfully" + " defeated all levels.\nCongratulations! You, " + hero.getPlayerName()
                                + ", have ascended to LEGENDARY" + " status!\n",
                        "GAME WON!", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "No Class Selected.");
            } else if (source == "Load") {
                createHero();
                JOptionPane.showMessageDialog(null, "Hero '" + hero.getPlayerName() + "' Created.", "CREATED",
                        JOptionPane.INFORMATION_MESSAGE);

                        removeCreateHero();
                        newStartGame();
            } else if (source == "nullName") {
                JOptionPane.showMessageDialog(null, "No Name Entered.", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (source == "nullType") {
                JOptionPane.showMessageDialog(null, "No Class Selected.", "WARNING", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Hero '" + hero.getPlayerName() + "' selected.", "LOADED",
                        JOptionPane.INFORMATION_MESSAGE);
                        removeLoadCharacter();
                        newStartGame();
            } else if (source == "Default") {
                JOptionPane.showMessageDialog(null, "Please select a hero");
            } else if (source == "NoFile") {
                JOptionPane.showMessageDialog(null, "No Saved Files detected in directory.", "WARNING", JOptionPane.ERROR_MESSAGE);
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
            } else if (source == "Console View") {
                App.setMap(map);
                App.setHero(hero);
                App.closeGui();
            }
        }
    }

    private void newMainMenu() {
        gui = new Gui();
        gui.addPropertyChangeListener(new MainMenuListener());

        this.add(gui);
        this.pack();
    }

    private void removeMainMenu() {
        this.remove(gui);
        this.gui = null;
    }

    private void newStartGame() {
        startGame = new StartGame(hero);
        startGame.addPropertyChangeListener(new StartGameListener());

        this.add(startGame);
        this.pack();
    }

    private void removeStartGame() {
        remove(startGame);
        startGame = null;
    }

    private void newCreateHero() {
        createHero = new CreateHero();
        createHero.addPropertyChangeListener(new CreateHeroListener());

        this.add(createHero);
        this.pack();
    }

    private void removeCreateHero() {
        this.remove(createHero);
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
        this.loadCharacter = null;
    }

    private void newSwitchView() {
        this.switchView = new SwitchView();
        this.switchView.addPropertyChangeListener(new SwitchViewListener());

        this.add(switchView);
        this.pack();
    }

    private void removeSwitchView() {
        this.remove(switchView);
        this.switchView = null;
    }

    public void displayHeroAttributes() {
        if (hero != null) {
            JOptionPane.showMessageDialog(null,
                    "Hero Attributes\n" + "- - - - - - - - -\n" + "Name:   " + hero.getPlayerName() + "\n" + "Class:  "
                            + hero.getType() + "\n" + "Level:  " + hero.getLevel() + "\n" + "EXP:    "
                            + hero.getExperience() + "\n" + "ATT:    " + hero.getAttack() + "\n" + "DEF:    "
                            + hero.getDefense() + "\n" + "HP:     " + hero.getHitPoints() + "\n\n" + "Hero Artifacts\n"
                            + "- - - - - - - -\n" + "Helmet: " + hero.getHelmet().getHitPoints() + " HP\n" + "Armor:  "
                            + hero.getArmor().getDefense() + " DEF\n" + "Weapon: " + hero.getWeapon().getAttack()
                            + " ATT\n",
                    "Help", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void displayHelp() {
        if (hero != null) {
            JOptionPane.showMessageDialog(null,
                    "Controls\n" + "- - - - -\n" + "North -  Up\n" + "West  -  Left\n" + "South -  Down\n"
                            + "East  -  Right\n\n" + "Map Key\n" + "- - - - -\n" + "o     -  Hero\n"
                            + "x     -  Villain\n" + ".     -  Empty\n",
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