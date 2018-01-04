package main.java.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlugaCarApplication{

	public static final Logger log = LoggerFactory.getLogger(AlugaCarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AlugaCarApplication.class, args);
	}
}
