package com.rutgerkloppenburg.api.RaspPiApi.old;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;
import java.util.List;

public class temp {

    //OLED oled;

    public temp() throws Exception {
        //oled = new OLED();
        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);
        TemperatureSensor tempDevice = null;
        for (W1Device device : w1Devices){
            tempDevice = (TemperatureSensor) device;
        }

        while (true){
            Thread.sleep(1000);
            //oled.showOnScreen("" + tempDevice.getTemperature());
        }


    }

}