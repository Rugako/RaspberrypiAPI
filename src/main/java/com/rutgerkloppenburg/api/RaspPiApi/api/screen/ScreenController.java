package com.rutgerkloppenburg.api.RaspPiApi.api.screen;

import com.google.gson.JsonObject;
import com.rutgerkloppenburg.api.RaspPiApi.RaspPiApiApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ScreenController {

    @PostMapping("/screen")
    void setScreen(@RequestBody Screen screen) throws Exception {
        screen.setScreen();
    }

    @GetMapping("/screen-history")
    String getScreenHistory(){
        JsonObject history = RaspPiApiApplication.app.fileWrapper.getFile("screen_history.json");
        return history.toString();
    }

}
