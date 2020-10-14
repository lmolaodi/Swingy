package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Map;
import view.ConsoleView;
import view.GuiFrame;
import model.characters.Hero;

public class App
{
    private static Hero hero = null;
    private static Map map;
    private static GuiFrame guiView = null;
    private static ConsoleView consoleView = null;
    public static void main( String[] args )
    {
        if (args.length == 0) {
            mainMenu();
        } else if (args.length == 1) {
            if (args[0].equals("console")) {
                mainMenu();
            } else if (args[0].equals("gui")) {
                changeViewGui();
            }
        }
    }

    public static void mainMenu() {
        System.out.println("---------------Swingy Text-based RPG Game----------");
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Start Game");
        System.out.println("2. Select Warrior");
        System.out.println("3. Change Display");
        System.out.println("\n0. Save & Exit");
        System.out.println();

        int option;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    startGame();
                    break;
                case 2:
                    selectCharacter();
                    break;
                case 3:
                    selectView();
                    break;
                case 0:
                    saveAndExit();
                    break;
                default:
                    System.out.println("\nIncorrect Value.\n");
                    mainMenu();
                    break;
            }
        } else {
            System.out.println("\nIncorrect Value.\n");
            mainMenu();
        }
    }

    private static void startGame() {

        if (hero == null) {
            System.out.println("\nNo warrior selected. Please select a warrior.");
            selectCharacter();
        } else {
            map = new Map(hero);
            changeViewConsole();
        }
    }

    private static void selectCharacter() {

        System.out.println("\nSelect Warrior");
        System.out.println("-------------");
        System.out.println("1. Create Warrior");
        System.out.println("2. Load Warrior");
        System.out.println("\n0. Cancel");
        System.out.println();

        int option;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    newCharacter();
                    break;
                case 2:
                    loadCharacter();
                    break;
                case 0:
                    System.out.println();
                    mainMenu();
                    break;
                default:
                    System.out.println("\nIncorrect Value.");
                    selectCharacter();
                    break;
            }
        } else {
            System.out.println("\nIncorrect Value.");
            selectCharacter();
        }
    }

    private static void newCharacter() {

        Scanner scanner = new Scanner(System.in);
        int option;
        String name;
        String type = "";

        System.out.println("\nEnter Warrior name: ");
        name = scanner.next();

        System.out.println("\nSelect Warrior classtype:  ");
        System.out.println("1. Warrior  ");
        System.out.println("2. Archer  ");
        System.out.println();

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    type = "Warrior";
                    break;
                case 2:
                    type = "Archer";
                    break;
                default:
                    System.out.println("\nIncorrect Value.");
                    newCharacter();
                    break;
            }
        } else {
            System.out.println("\nIncorrect Value.");
            newCharacter();
        }

        System.out.println("\nCreate Warrior '" + name + "' of classtype '" + type + "'?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("\n0. Cancel");
        System.out.println();

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println();
                    mainMenu();
                    break;
                case 1:
                    System.out.println("\nWarrior Created.");
                    createCharacter(name, type);
                    System.out.println();
                    mainMenu();
                    break;
                case 2:
                    selectCharacter();
                    break;
                default:
                    System.out.println("\nIncorrect Value.");
                    newCharacter();
                    break;
            }
        } else {
            System.out.println("\nIncorrect Value.");
            newCharacter();
        }
    }

    private static void createCharacter(String name, String type) {
        hero = new Hero(name, type);
    }

    private static void loadCharacter() {

        try {
            ArrayList<String> list = new ArrayList<>();

            String fileName = System.getProperty("user.dir") + "/src/main/java/savedGameData/";
            File folder = new File(fileName);
            File[] listOfFiles = folder.listFiles();
            System.out.println("\nSaved Files");
            System.out.println("-----------");

            // TODO: check for exception
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter filename to load:");
            String textFile = scanner.nextLine();
            fileName = System.getProperty("user.dir") + "/src/main/java/savedGameData/" + textFile;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("\nfile does not exist.");
                loadCharacter();
            }
            hero = new Hero(list);
            System.out.println("\nSaved file Loaded.\n");
            mainMenu();
        } catch (Exception E) {
            System.out.println("\nNo Saved Files Detected.\n");
            mainMenu();
        }
    }

    private static void selectView() {
        int option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSelect View");
        System.out.println("-----------");
        System.out.println("1. Console View");
        System.out.println("2. Graphical View");
        System.out.println("\n0. Cancel");
        System.out.println();

        if (scanner.hasNextInt()) {
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println();
                    mainMenu();
                    break;
                case 1:
                    System.out.println("\nConsole View selected.\n");
                    mainMenu();
                    break;
                case 2:
                    changeViewGui();
                    break;
                default:
                    System.out.println("\nIncorrect Value.");
                    selectView();
                    break;
            }
        } else {
            System.out.println("\nIncorrect Value.");
            selectView();
        }
    }

    private static void saveAndExit() {

        if (hero != null) {

            int option;
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nDo you want to save Game");
            System.out.println("----------");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println("\n0. Cancel");
            System.out.println();

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 0:
                        System.out.println();
                        mainMenu();
                        break;
                    case 1:
                        saveGameFile();
                        System.out.println("\nGame Saved.");
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nIncorrect Value.");
                        saveAndExit();
                        break;
                }
            } else {
                System.out.println("\nIncorrect Value.");
                saveAndExit();
            }
        }
    }

    private static void saveGameFile() {
        ArrayList<String> list;
        try {
            String textFile = hero.getPlayerName() + "_" + hero.getType() + "_" + hero.getLevel() + "_"
                    + hero.getExperience() + ".txt";

            String fileName = System.getProperty("user.dir") + "/src/main/java/savedGameData/" + textFile;
            PrintWriter file = new PrintWriter(fileName);
            list = hero.saveAttributes();
            for (String str : list) {
                file.println(str);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can not save to directory");
            System.exit(0);
        }
    }

    public static void closeGui() {
        guiView.closeFrame();
        guiView = null;
        mainMenu();
    }

    public static void changeViewConsole() {
        consoleView = new ConsoleView(map, hero);
    }

    public static void changeViewGui() {
        guiView = new GuiFrame(map, hero);
    }

    public void loadMenu() {
        consoleView = null;
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        App.hero = hero;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        App.map = map;
    }
}
