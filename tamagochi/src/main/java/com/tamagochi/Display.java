package com.tamagochi;

import java.io.Console;
import java.util.NoSuchElementException;
import java.util.Scanner;

public interface Display {
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
    
    public static String displayPetInfos(Tamagochi pet , Scanner scanner) {
        System.out.print("\033[H\033[2J");
        System.out.println("Day : " + (pet.age - 1));
        System.out.println("Name : " + pet.name);
        System.out.println("State : " + pet.state);
        if(pet.foodTime == true) {
            System.out.println( yellowBack +"Hunger : already fed today" + ANSI_RESET);
        } else {
            System.out.println(yellowBack + "Hunger : not fed today" + ANSI_RESET);
        }
        if(pet.Isclean == true) {
            System.out.println("Clean : clean");
        } else {
            System.out.println("Clean : not clean");
        }
        System.out.println(purpleBack+ "Happiness : " + pet.happiness + "/50" + ANSI_RESET + pet.happiness);
        if(pet.IsSick == true) {
            System.out.println(redBack + pet.name + " is sick, you need to heal him today !"  + ANSI_RESET);
        }
        return askWhatToDo(scanner);
    }
    
    static String askWhatToDo(Scanner scanner) {

        System.out.println("Choose an action :");
        System.out.println("1 - Feed");
        System.out.println("2 - Play");
        System.out.println("3 - Wash");
        System.out.println("4 - Heal");
        System.out.println("5 - Exit");
        System.out.print("  - Enter your choice => ");
        try {
            String choice = scanner.nextLine();
            return choice;
        }
        catch (NoSuchElementException e) {
           return "10";
        }
        catch (IllegalStateException e) {
            return "10";
        }
        
   
}

}
