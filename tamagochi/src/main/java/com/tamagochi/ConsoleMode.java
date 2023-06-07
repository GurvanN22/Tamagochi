package com.tamagochi;

public class ConsoleMode implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String PURPLE = "\033[0;35m";
    public static final String WHITE_BACKGROUND = "\033[47m";

    public static final String reset = "\u001B[0m";
    public static final String purple = "\033[0;35m";
    public static final String whiteBack = "\033[47m";
    public static final String purpleBack = "\u001B[45m";
    public static final String redBack = "\u001B[41m";
    public static final String yellowBack = "\u001B[43m";
    Tamagochi pet = new Tamagochi("Bird");

    public ConsoleMode() {
        System.out.print("\033[H\033[2J");
        System.out.println("Welcome to the tamagochi console mode !\n\n\n\n\n\n\n");
        try {
            String asciiBeast = getClass().getResource("/AsciiArt/bird").toString();
            System.out.println("Ton tamagochi ? (temp)");
        } catch (Exception e) {
            System.out.println("Error while loading the ascii art");
        }
        displayPetInfos();
    }

    private void displayPetInfos() {
        System.out.println("Name : " + pet.name);
        System.out.println("Age : " + pet.age);
        System.out.println("Health : ");
        displayColorLine(redBack, pet.health);
        System.out.println("Hunger : ");
        displayColorLine(yellowBack, pet.hunger);
        System.out.println("Happiness : ");
        displayColorLine(purpleBack, pet.happiness * 2);
    }

    void displayColorLine(String color, int number) {
        String coloredSpaces = "";
        String whiteSpaces = "";
        while (number > 0) {
            coloredSpaces += " ";
            number--;
        }
        number = 100 - coloredSpaces.length();
        while (number > 0) {
            whiteSpaces += " ";
            number--;
        }
        System.out.println(color + coloredSpaces + whiteBack + whiteSpaces + reset);
    }

    public static void main(String[] args) {
        ConsoleMode consoleMode = new ConsoleMode();
        Thread thread = new Thread(consoleMode);
        thread.start();
    }

    @Override
    public void run() {
        ConsoleMode consoleMode = new ConsoleMode();
    }
}

