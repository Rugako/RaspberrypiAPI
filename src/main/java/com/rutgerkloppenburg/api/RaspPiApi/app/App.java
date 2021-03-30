package com.rutgerkloppenburg.api.RaspPiApi.app;

import com.rutgerkloppenburg.api.RaspPiApi.app.files.FileWrapper;
import com.rutgerkloppenburg.api.RaspPiApi.app.screen.Screen;
import com.rutgerkloppenburg.api.RaspPiApi.app.sensors.TempratureSensor;

public class App {

    public Screen screen;
    public FileWrapper fileWrapper;
    public TempratureSensor tempratureSensor;

    public App() throws Exception {
        initializeObjects();
    }

    private void initializeObjects() throws Exception {
        screen = new Screen();
        fileWrapper = new FileWrapper();
        tempratureSensor = new TempratureSensor();
    }

}
