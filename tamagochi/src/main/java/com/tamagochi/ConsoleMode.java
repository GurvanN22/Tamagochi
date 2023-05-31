package com.tamagochi;

import java.nio.file.Paths;

import com.Tamagochi;

import javafx.scene.shape.Path;

public class ConsoleMode {
    public static final String reset = "\u001B[0m";
    public static final String purple = "\033[0;35m";
    public static final String whiteBack = "\033[47m";
    public static final String purpleBack = "\u001B[45m";
    public static final String redBack = "\u001B[41m";
    public static final String yellowBack = "\u001B[43m";
    Tamagochi pet = new Tamagochi("Bird");
    ConsoleMode() {
        System.out.print("\033[H\033[2J");  
        System.out.println("Welcome to the tamagochi console mode !\n\n\n\n\n\n\n");
        try {
            String asciiBeast = getClass().getResource("/AsciiArt/bird").toString();
            System.out.println(" Ton tamagochi ? (temp)");
        }
        catch( Exception e) {
            System.out.println("Error while loading the ascii art");
        }
        displayPetInfos();
    }
    private void displayPetInfos() {
        System.out.println("Name : " + pet.name);
        System.out.println("Age : " + pet.age);
        System.out.println("Health : ");
        displayColorLine(redBack, pet.health );
        System.out.println("Hunger : ");
        displayColorLine(yellowBack, pet.hunger);
        System.out.println("Happiness : ");
        displayColorLine(purpleBack, pet.happiness*2);
    }
    void displayColorLine(String color,int Number) {
        String coloredSpaces = "";
        String whiteSpaces = "";
        while (Number > 0) {
            coloredSpaces += " ";
            Number--;
        }
        Number = 100 - coloredSpaces.length();
        while (Number > 0) {
            whiteSpaces += " ";
            Number--;
        }
        System.out.println(color + coloredSpaces + whiteBack + whiteSpaces + reset);
    }
}
