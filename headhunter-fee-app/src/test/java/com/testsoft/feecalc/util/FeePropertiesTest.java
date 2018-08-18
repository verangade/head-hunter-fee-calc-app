package com.testsoft.feecalc.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeePropertiesTest {
	
	@Autowired
	private FeeProperties feeProperties;
	
	@Test
	public void testGroupSizeProperties() {
		int size = feeProperties.getGroupSize();
		assertThat(size).isEqualTo(5);		
	}
	
	@Test
	public void testCarpenterValueProperties() {
		int value = feeProperties.getCarpenterValue();		
		assertThat(value).isEqualTo(250);	
	}
	
	@Test
	public void testMasonValueProperties() {
		int value = feeProperties.getMasonValue();		
		assertThat(value).isEqualTo(200);	
	}
	
	@Test
	public void testCommissionValueProperties() {
		double value = feeProperties.getCommisionPercentage();		
		assertThat(value).isEqualTo(0.1);	
	}
	

}
