package com.mso.ph.programhelper;

import com.mso.ph.programhelper.data.model.person.PersonsData;
import com.mso.ph.programhelper.data.model.settings.AppSettings;
import com.mso.ph.programhelper.data.store.AppSettingsStore;
import com.mso.ph.programhelper.data.store.PersonStore;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AppCtx {

    private static AppSettings appSettings;
    private static PersonsData personsData;

    public static void init() throws IOException{
       var settingsFilePath = getSettingsFilePath();
       var fileSetting = new java.io.File(settingsFilePath);
         if (fileSetting.exists()) {
              appSettings = AppSettingsStore.loadSettings(settingsFilePath);
         } else {
                appSettings = new AppSettings();
                var currentDirectory = System.getProperty("user.dir");
                appSettings.getDataSettings().setDataFolderPath(currentDirectory + "/app-data");
                AppSettingsStore.saveSettings(settingsFilePath, appSettings);
         }
    }

    public static void saveAppSettings() throws IOException {
        AppSettingsStore.saveSettings(getSettingsFilePath(), appSettings);
    }
    public void savePersons() throws IOException {
        createFolderIfNotExists(getPersonsDataFilePath());
        PersonStore.SavePerson(getPersonsDataFilePath(), personsData);
    }

    public void loadPersons() throws IOException {
        personsData = PersonStore.LoadPerson(getPersonsDataFilePath());
    }

    @NotNull
    private static String getSettingsFilePath()  {
        var currentDirectory = System.getProperty("user.dir");
        return currentDirectory + "/settings.json";
    }

    public static PersonsData getPersonsData() {
        return personsData;
    }

    public static AppSettings getAppSettings() {
        return appSettings;
    }

    public static String GetDataFolderPath() {
        return appSettings.getDataSettings().getDataFolderPath();
    }

    public static String getPersonsDataFilePath() {
        return GetDataFolderPath() + "/persons.json";
    }

    public static String createFolderIfNotExists(String folderPath) {
        var folder = new java.io.File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folderPath;
    }
}
