package com.tamagochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * Tamagochi App
 * {@link} https://github.com/GurvanN22/Tamagochi
 **/
public class App extends Application {
    /**
     * The menu selection of the tamagochi type.
     **/
    private void initSelectionMenu(Stage stage) {
        Button consoleButton = new Button("Play in console mode");
        Button fxButton = new Button("Play in FX mode");
        consoleButton.getStyleClass().add("main-menu-button");
        consoleButton.setOnAction(e -> {
        });
        fxButton.setOnAction(e -> {
            new FXmode(stage);
        });
        HBox H1 = new HBox( consoleButton , fxButton);
        Scene chooseModeScene = new Scene(H1, 640, 480);
        chooseModeScene.setOnKeyPressed(event -> {
        String codeString = event.getCode().toString();});
        String cssPath = getClass().getResource("/css/start-game.css").toString();
        chooseModeScene.getStylesheets().add(cssPath);
        stage.setScene(chooseModeScene);
        stage.show();
    }
    @Override
    public void start(Stage stage) {
       //new FXmode(stage);
       initSelectionMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}