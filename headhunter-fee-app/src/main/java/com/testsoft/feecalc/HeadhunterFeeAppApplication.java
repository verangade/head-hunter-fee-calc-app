package com.testsoft.feecalc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.testsoft.feecalc.util.FeeProperties;

@SpringBootApplication
public class HeadhunterFeeAppApplication {

	@Autowired
	private FeeProperties feeProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(HeadhunterFeeAppApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		System.out.println(feeProperties.getCarpenterValue());
		System.out.println(feeProperties.toString());
	}
	
}
