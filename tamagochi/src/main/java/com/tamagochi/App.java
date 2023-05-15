package com.tamagochi;

import java.io.InputStream;

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
 * JavaFX App
 */
public class App extends Application {

    private Scene mainScene;

    public void initMenu(Stage stage) {
        //Class<?> clazz = this.getClass();
        //InputStream input = clazz.getResourceAsStream("./assets/img/flo.png");
        //Image image = new Image(input);
        //ImageView imageView = new ImageView(image);
        //imageView.setFitWidth(50);
        //imageView.setFitHeight(50);
        Button feedButton = new Button("Feed");
        feedButton.getStyleClass().add("main-menu-button");
        Button playButton = new Button("Play");
        playButton.getStyleClass().add("main-menu-button");
        Button healButton = new Button("heal");
        healButton.getStyleClass().add("main-menu-button");
        Button cleanButton = new Button("clean");
        cleanButton.getStyleClass().add("main-menu-button");
        feedButton.setOnAction(e -> {
            
        });
        HBox H1 = new HBox(feedButton , healButton);
        HBox H2 = new HBox(playButton , cleanButton);
        VBox V1 = new VBox( H1 , H2);
        mainScene = new Scene(V1, 640, 480);
        String cssPath = getClass().getResource("/app.css").toString();
        mainScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        initMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}