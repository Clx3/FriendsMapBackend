package fi.tuni.friendsmap;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"fi.tuni.friendsmap",
		"fi.tuni.friendsmap.configuration",
		"fi.tuni.friendsmap.controller",
		"fi.tuni.friendsmap.entity",
		"fi.tuni.friendsmap.repository"})
public class Application {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}