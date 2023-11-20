package com.mso.ph.programhelper;

import com.mso.ph.programhelper.settings.logic.SettingsLogic;
import com.mso.ph.programhelper.settings.model.AppSettings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static AppSettings appSettings;
    @Override
    public void start(Stage stage) throws IOException {
        var settingsLogic = new SettingsLogic();
        settingsLogic.init();
        appSettings = settingsLogic.getAppSettings();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Program helper!");
        stage.setScene(scene);
        stage.show();

        settingsLogic.saveSettings();
    }


    public static void main(String[] args) {
        launch();
    }
}