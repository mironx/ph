package com.mso.ph.programhelper.settings.logic;

import com.mso.ph.programhelper.json.JsonUtil;
import com.mso.ph.programhelper.settings.model.AppSettings;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class SettingsLogic {

    private AppSettings appSettings;

    public void init() throws IOException {
        var settingsFilePath  = getSettingsFilePath();
        File settingsFile = new File(settingsFilePath);
        if (settingsFile.exists()) {
           loadSettings(settingsFilePath);
        } else {
            appSettings = new AppSettings();
            saveSettings(settingsFilePath);
        }
    }

    public void saveSettings() throws IOException {
        var settingsFilePath  = getSettingsFilePath();
        saveSettings(settingsFilePath);
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    private void loadSettings(String settingsFilePath) throws IOException {
        appSettings =  JsonUtil.fromJsonFile(Path.of(settingsFilePath), AppSettings.class);
    }

    private void saveSettings(String settingsFilePath) throws IOException {
        JsonUtil.toJsonFile(Path.of(settingsFilePath), appSettings);
    }

    @NotNull
    private String getSettingsFilePath()  {
        var currentDirectory = System.getProperty("user.dir");
        return currentDirectory + "/settings.json";
    }
}
