package com.tamagochi;

public class ConsoleMode {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String WHITE_BACKGROUND = "\033[47m";
    ConsoleMode() {
        System.out.print("\033[H\033[2J");  
        System.out.println(WHITE_BACKGROUND + WHITE_BACKGROUND +  "Welcome to the tamagochi console mode !");
    }
}
