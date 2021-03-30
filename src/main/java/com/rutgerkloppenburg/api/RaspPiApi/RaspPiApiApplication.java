package com.rutgerkloppenburg.api.RaspPiApi;


import com.rutgerkloppenburg.api.RaspPiApi.app.App;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class RaspPiApiApplication {

	public static App app;

	public static void main(String[] args) throws Exception {
		run(RaspPiApiApplication.class, args);
		app = new App();
	}

}
