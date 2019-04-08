package ch.noseryoung.uekbewertung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class UekBewertungApplication {

	public static void main(String[] args) {
		SpringApplication.run(UekBewertungApplication.class, args);
	}
}
