package com.rutgerkloppenburg.api.RaspPiApi.app.sensors;

import com.google.gson.JsonObject;
import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import com.rutgerkloppenburg.api.RaspPiApi.RaspPiApiApplication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TempratureSensor {

    private TemperatureSensor rednecktemp;

    public TempratureSensor() { ;
        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);
        for (W1Device device : w1Devices){
            rednecktemp = (TemperatureSensor) device;
        }
        this.forestFire();
    }

    public void forestFire() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                saveTempToFile(rednecktemp.getTemperature());
            }
        }, 0, 60000);
    }

    private void saveTempToFile(double temp) {
        JsonObject tempFile = RaspPiApiApplication.app.fileWrapper.getFile("temp-history.json");
        ArrayList<String> removeHistory = new ArrayList<String>();
        // Remove temp history records older than 1 hour.
        tempFile.keySet().forEach(key -> {
            long diffInTime = new Timestamp(System.currentTimeMillis()).getTime() - Long.parseLong(key);
            if(diffInTime >= 3600000){
                removeHistory.add(key);
            }
        });
        for(String key : removeHistory){
            tempFile.remove(key);
        }
        JsonObject tempHistory = new JsonObject();
        tempHistory.addProperty("tempCelsius", temp);
        tempFile.add("" + new Timestamp(System.currentTimeMillis()).getTime(), tempHistory);
        RaspPiApiApplication.app.fileWrapper.writeFile("temp-history.json", tempFile);
    }

}
