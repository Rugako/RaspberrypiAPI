package com.rutgerkloppenburg.api.RaspPiApi.old;

import java.util.HashMap;

public class Tempratuur {

    private HashMap<String, String> temps = new HashMap<>();
    private String temp;

    public Tempratuur(String city){
        initTemps();
        temp = temps.get(city);
    }

    private void initTemps(){
        temps.put("duiven", "25");
        temps.put("didam", "-25");
    }

    public String getTemp(){
        return temp;
    }

}
