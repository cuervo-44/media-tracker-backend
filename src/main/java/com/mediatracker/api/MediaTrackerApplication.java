package com.mediatracker.api;

import java.awt.Desktop;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MediaTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaTrackerApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
    public void abrirNavegador() {
        try {
            String url = "http://localhost:8080";
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
