package com.singura.jpos;

import org.jpos.q2.Q2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JposDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JposDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Q2 q2 = new Q2();
		Thread thread = new Thread(q2);
		thread.start();
	}
}
