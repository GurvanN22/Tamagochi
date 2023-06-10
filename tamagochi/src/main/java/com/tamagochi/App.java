package com.tamagochi;

import java.io.Console;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Tamagochi App
 * {@link} https://github.com/GurvanN22/Tamagochi
 **/
public class App extends Application implements Save {
    /**
     * The menu selection of the tamagochi type.
     **/
    private void initSelectionMenu(Stage stage) {
        Button consoleButton = new Button("Play in console mode(not recommanded :) )");
        Button fxButton = new Button("Play in FX mode(recommanded)");
        consoleButton.getStyleClass().add("main-menu-button");
        fxButton.getStyleClass().add("start-menu-button");
        consoleButton.getStyleClass().add("start-menu-button");
        consoleButton.setOnAction(e -> {
            stage.close();
            new ConsoleMode();
        });
        fxButton.setOnAction(e -> {
            new FXmode(stage);
        });
        Label label = new Label("Choose your mode");
        VBox V1 = new VBox(label, consoleButton, fxButton);
        Scene chooseModeScene = new Scene(V1, 680, 480);
        chooseModeScene.setOnKeyPressed(event -> {
        String codeString = event.getCode().toString();
    });
        String cssPath = getClass().getResource("/css/start-game.css").toString();
        chooseModeScene.getStylesheets().add(cssPath);
        stage.setScene(chooseModeScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
       //new FXmode(stage);
       System.out.print("\033[H\033[2J"); 
       initSelectionMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}