package com.tamagochi;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXmode implements Save{
    private Timer timer;
    /**
    * The main scene of the tamagochi.
    **/
    private Scene mainScene;
    Stage stage;
    Tamagochi pet;
    /**
    * start the tamagochi
    **/
    FXmode(Stage stage) {
        this.stage = stage;
        pet = load();
        if (pet.IsNew == true) {
            pet.IsNew = false;
            pet.name = "tama";
        }
        initMenu();
        timer = new Timer();
        timer.schedule(new GrowTask(), 0, 10000);
    }
    /**
    * init the main menu of the tamagochi
    **/
    private void initMenu() {
        if(pet.IsDead == true) {
            Label deadLabel = new Label("tama pet is dead , RIP");
            deadLabel.getStyleClass().add("main-menu-text");
            Button exitButton = new Button("exit");
            exitButton.setOnAction(e -> {
                save(pet);
                System.exit(0);
            });
            VBox V2 = new VBox(deadLabel , exitButton);
            mainScene = new Scene(V2, 640, 480);
            String cssPath = getClass().getResource("/css/main-menu.css").toString();
            mainScene.getStylesheets().add(cssPath);
            stage.setScene(mainScene);
            stage.show();
        } else {
            if (pet.IsEgg == true) {
                Label EggLabel = new Label("tama is a egg wait 1 day");
                EggLabel.getStyleClass().add("main-menu-text");
                mainScene = new Scene(EggLabel, 640, 480);
                String cssPath = getClass().getResource("/css/main-menu.css").toString();
                mainScene.getStylesheets().add(cssPath);
                stage.setScene(mainScene);
                stage.show();
            } else {
                Label feedLabel;        
                Label cleanLabel;           
                Label sickLabel;
                
                
                
                if(pet.foodTime == true) {
                    feedLabel = new Label(pet.name + " is not hungry anymore");
                } else {
                    feedLabel = new Label(pet.name + " is hungry");
                }
                if(pet.Isclean == true) {
                    cleanLabel = new Label(pet.name + " is clean");
                } else {
                    cleanLabel = new Label(pet.name + " is dirty");
                }
                if(pet.IsSick == true) {
                    sickLabel = new Label(pet.name + " is Sick");
                } else {
                    sickLabel = new Label(pet.name + " is Healthy");
                }
                Label hapiness = new Label("Happiness" + pet.happiness + "/50");
                Label name = new Label("Name : " + pet.name);
                Label age = new Label("Age " + pet.age + " days");
                Label state = new Label("State :" + pet.state);
                feedLabel.getStyleClass().add("main-menu-text");
                cleanLabel.getStyleClass().add("main-menu-text");
                sickLabel.getStyleClass().add("main-menu-text");
                hapiness.getStyleClass().add("main-menu-text");
                name.getStyleClass().add("main-menu-text");
                age.getStyleClass().add("main-menu-text"); 
                state.getStyleClass().add("main-menu-text");
                
                
                Button feedButton = new Button("Feed");
                feedButton.getStyleClass().add("main-menu-button-feed");
                Button playButton = new Button("Play");
                playButton.getStyleClass().add("main-menu-button-play");
                Button healButton = new Button("heal");
                healButton.getStyleClass().add("main-menu-button-heal");
                Button cleanButton = new Button("clean");
                cleanButton.getStyleClass().add("main-menu-button-clean");
                
                feedButton.setOnAction(e -> {
                    pet.feed();
                    initMenu();
                });
                playButton.setOnAction(e -> {
                    pet.play();
                    initMenu();
                });
                healButton.setOnAction(e -> {
                    pet.heal();
                    initMenu();
                });
                cleanButton.setOnAction(e -> {
                    pet.wash();
                    initMenu();
                });
                
                HBox H1 = new HBox(feedButton , healButton);
                HBox H2 = new HBox(playButton , cleanButton);        
                VBox V2 = new VBox(name , age ,state, hapiness , feedLabel , cleanLabel , sickLabel);
                VBox V1 = new VBox(V2 ,H1 , H2);
                mainScene = new Scene(V1, 840, 680);
                String cssPath = getClass().getResource("/css/main-menu.css").toString();
                mainScene.getStylesheets().add(cssPath);
                stage.setScene(mainScene);
                stage.show();
            }
            
        }
        
    }
    private void grow() {
        Platform.runLater(() -> {
            pet.grow();
            initMenu();
            System.out.println(pet.happiness);
            save(pet);
        });
    }
    private class GrowTask extends TimerTask {
        @Override
        public void run() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(FXmode.this::grow);
            executor.shutdown();
        }
    }
}