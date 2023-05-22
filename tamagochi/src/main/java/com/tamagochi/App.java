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
 * Tamagochi App
 * {@link} https://github.com/GurvanN22/Tamagochi
 **/
public class App extends Application {
    /**
     * The main scene of the tamagochi.
     **/
    private Scene mainScene;
    /**
     *  The feed scene of the tamagochi 
     **/
    private Scene feedScene;
    /**
     *  The play scene of the tamagochi 
     **/
    private Scene playScene;
    /**
     *  The heal scene of the tamagochi 
     **/
    private Scene HealScene;
    /**
     *  The clean scene of the tamagochi 
     **/
    private Scene cleanScene;
    /**
     * init the main menu of the tamagochi
     **/
    private void initMenu(Stage stage) {
        Button feedButton = new Button("Feed");
        feedButton.getStyleClass().add("main-menu-button");
        Button playButton = new Button("Play");
        playButton.getStyleClass().add("main-menu-button");
        Button healButton = new Button("heal");
        healButton.getStyleClass().add("main-menu-button");
        Button cleanButton = new Button("clean");
        cleanButton.getStyleClass().add("main-menu-button");

        feedButton.setOnAction(e -> {
            stage.setScene(feedScene);
            stage.show();
        });
        playButton.setOnAction(e -> {
            stage.setScene(playScene);
            stage.show();
        });
        healButton.setOnAction(e -> {
            stage.setScene(HealScene);
            stage.show();
        });
        cleanButton.setOnAction(e -> {
            stage.setScene(cleanScene);
            stage.show();
        });


        HBox H1 = new HBox(feedButton , healButton);
        HBox H2 = new HBox(playButton , cleanButton);
        VBox V1 = new VBox( H1 , H2);
        mainScene = new Scene(V1, 640, 480);
        String cssPath = getClass().getResource("/css/main-menu.css").toString();
        mainScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * init the feed menu of the tamagochi
     **/
    private void initFeed(Stage stage) {
        Button returnButton = new Button("return");
        returnButton.getStyleClass().add("main-menu-button");
        returnButton.setOnAction(e -> {
            stage.setScene(mainScene);
            stage.show();
        });
        VBox V1 = new VBox( returnButton);
        feedScene = new Scene(V1, 640, 480);
        feedScene.setOnKeyPressed(event -> {
        String codeString = event.getCode().toString();});
        String cssPath = getClass().getResource("/css/feed-menu.css").toString();
        feedScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * init the game menu of the tamagochi
     **/
    private void initGame(Stage stage) {
        Button returnButton = new Button("return");
        returnButton.getStyleClass().add("main-menu-button");
        returnButton.setOnAction(e -> {
            stage.setScene(mainScene);
            stage.show();
        });
        VBox V1 = new VBox( returnButton);
        playScene = new Scene(V1, 640, 480);

        String cssPath = getClass().getResource("/css/play-menu.css").toString();
        playScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * init the heal menu of the tamagochi
     **/
    private void initHeal(Stage stage) {
        Button returnButton = new Button("return");
        returnButton.getStyleClass().add("main-menu-button");
        returnButton.setOnAction(e -> {
            stage.setScene(mainScene);
            stage.show();
        });
        VBox V1 = new VBox( returnButton);
        HealScene = new Scene(V1, 640, 480);
        String cssPath = getClass().getResource("/css/heal-menu.css").toString();
        HealScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * init the clean menu of the tamagochi
     **/
    private void initClean(Stage stage) {
        Button returnButton = new Button("return");
        returnButton.getStyleClass().add("main-menu-button");
        returnButton.setOnAction(e -> {
            stage.setScene(mainScene);
            stage.show();
        });
        VBox V1 = new VBox( returnButton);
        cleanScene = new Scene(V1, 640, 480);
        String cssPath = getClass().getResource("/css/clean-menu.css").toString();
        cleanScene.getStylesheets().add(cssPath);
        stage.setScene(mainScene);
        stage.show();
    }
    /**
     * start the tamagochi
     **/
    
    @Override
    public void start(Stage stage) {
        initMenu(stage);
        initFeed(stage);
        initGame(stage);
        initHeal(stage);
        initClean(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}