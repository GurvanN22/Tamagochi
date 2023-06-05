package com.tamagochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXmode extends Application implements Runnable {
    /**
     * The main scene of the tamagotchi.
     **/
    private Scene mainScene;
    /**
     *  The feed scene of the tamagotchi
     **/
    private Scene feedScene;
    /**
     *  The play scene of the tamagotchi
     **/
    private Scene playScene;
    /**
     *  The heal scene of the tamagotchi
     **/
    private Scene healScene;
    /**
     *  The clean scene of the tamagotchi
     **/
    private Scene cleanScene;

    private Stage stage;

    public FXmode(Stage stage) {
    }

    public static void main(String[] args) {
        FXmode fxMode = new FXmode();
        Thread thread = new Thread(fxMode);
        thread.start();
    }

    @Override
    public void run() {
        launch(new String[]{});
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        initMenu();
        initFeed();
        initGame();
        initHeal();
        initClean();
    }

    /**
     * init the main menu of the tamagotchi
     **/
    private void initMenu() {
        // ... le code du menu principal

        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * init the feed menu of the tamagotchi
     **/
    private void initFeed() {
        // ... le code du menu de nourriture

        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * init the game menu of the tamagotchi
     **/
    private void initGame() {
        // ... le code du menu de jeu

        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * init the heal menu of the tamagotchi
     **/
    private void initHeal() {
        // ... le code du menu de guérison

        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * init the clean menu of the tamagotchi
     **/
    private void initClean() {
        // ... le code du menu de nettoyage

        stage.setScene(mainScene);
        stage.show();
    }
}
