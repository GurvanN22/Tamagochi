package com.tamagochi;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsoleMode implements Display, Save {
    private Tamagochi pet;
    private Timer timer;
    private Scanner scanner = new Scanner(System.in);
    
    public ConsoleMode() {
        pet = load();
        if (pet.IsEgg) {
            System.out.print("\033[H\033[2J");
            if (pet.IsNew) {
                System.out.print("What is his name? => ");
                String name = scanner.nextLine();
                pet.name = name;
                pet.IsNew = false;
                save(pet);
                
                System.out.print("\033[H\033[2J");
            }
            System.out.println(pet.name + " is an egg! He has " + pet.age + " days.\n");
        }
        // Start the timer to call the grow() method every ten seconds
        timer = new Timer();
        timer.schedule(new GrowTask(), 0, 10000);
    }
    
    private void makeAction() {
        while(true) {
             String choice = Display.displayPetInfos(this.pet , scanner);
        switch (choice) {
            case "1":
            this.pet.feed();
            break;
            case "2":
            this.pet.play();
            break;
            case "3":
            this.pet.wash();
            break;
            case "4":
            this.pet.heal();
            break;
            case "5":
            save(this.pet);
            System.exit(0);
            break;
        }
        }
    }
    
    public void grow() {
        pet.grow();
        switch (pet.state) {
            case "egg":
            System.out.println(pet.name + " is an egg! He has " + pet.age + " days.\n");
            break;
            case "dead":
            System.out.println(pet.name + " is dead! Reload the game to play again.");
            save(pet);
            System.exit(0);
            default:
            makeAction();
            break;
        }
        save(pet);
    }
    
    private class GrowTask extends TimerTask {
        @Override
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(ConsoleMode.this::grow);
            executor.shutdown();
        }
    }
}
