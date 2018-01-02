package main.java.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

	
	@Autowired
	public DataLoader() {
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
	}
}
