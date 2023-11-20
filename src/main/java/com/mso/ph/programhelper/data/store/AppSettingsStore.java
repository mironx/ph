package com.mso.ph.programhelper.data.store;

import com.mso.ph.programhelper.data.model.settings.AppSettings;
import com.mso.ph.programhelper.json.JsonUtil;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.nio.file.Path;

public class AppSettingsStore {
    public static AppSettings loadSettings(String path)  throws IOException {
        return JsonUtil.fromJsonFile(Path.of(path), AppSettings.class);
    }

    public static  void saveSettings(String path, AppSettings appSettings) throws IOException {
        JsonUtil.toJsonFile(Path.of(path), appSettings);
    }
}
