package com.TradeMicro.TAM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.activation.DataSource;

@SpringBootApplication
public class TamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TamApplication.class, args);
	}
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) {
	        try {
	            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STOCKTRADES", Integer.class);
	            if(count > 0) System.out.println("✅ Connected to Oracle DB.");
	        } catch (Exception e) {
	            System.err.println(" Failed to connect to Oracle DB: " + e.getMessage());
	        }
	    }
	
	


}
