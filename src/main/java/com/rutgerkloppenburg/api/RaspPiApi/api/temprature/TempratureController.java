package com.rutgerkloppenburg.api.RaspPiApi.api.temprature;

import com.google.gson.JsonObject;
import com.rutgerkloppenburg.api.RaspPiApi.RaspPiApiApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TempratureController {

    @GetMapping("/temp-history")
    public String getTempHistory(){
        JsonObject history = RaspPiApiApplication.app.fileWrapper.getFile("temp-history.json");
        return history.toString();
    }

}
