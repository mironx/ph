package com.mso.ph.programhelper;

import com.mso.ph.programhelper.data.store.AppSettingsStore;
import com.mso.ph.programhelper.data.model.settings.AppSettings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       AppCtx.init();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Program helper!");
        stage.setScene(scene);
        stage.show();
        AppCtx.saveAppSettings();
    }


    public static void main(String[] args) {
        launch();
    }
}