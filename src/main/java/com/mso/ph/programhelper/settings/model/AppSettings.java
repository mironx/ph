package com.mso.ph.programhelper.settings.model;

public class AppSettings {

    public AppSettings() {
        windowState = new WindowState();
        dataSettings = new DataSettings();
    }
    private WindowState windowState;
    private DataSettings dataSettings;

    public WindowState getWindowState() {
        return windowState;
    }

    public void setWindowState(WindowState windowState) {
        this.windowState = windowState;
    }

    public DataSettings getDataSettings() {
        return dataSettings;
    }

    public void setDataSettings(DataSettings dataSettings) {
        this.dataSettings = dataSettings;
    }
}

