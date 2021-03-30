package com.rutgerkloppenburg.api.RaspPiApi.old;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempratuurController {

    @GetMapping("/tempratuur")
    @ResponseBody
    public Tempratuur temp(@RequestParam(name="city", required = true) String city){
        return new Tempratuur(city);
    }

}
