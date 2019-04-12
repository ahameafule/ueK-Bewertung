package ch.noseryoung.uekbewertung.config.security;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PropertiesConfiguration {

	@Bean
	public Properties jwtProperties() throws IOException {
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/jwt.properties"));
		return props;
	}

	@Primary
	@Bean
	public Properties applicationProperties() throws IOException {
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/application.properties"));
		return props;
	}

}
