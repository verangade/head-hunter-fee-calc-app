package com.testsoft.feecalc.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.Recruit;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class FeeCalculatorComponentTest {

	@Autowired
	private FeeCalculatorComponent feeCalculatorComponent;

	private List<Recruit> recruitList = new ArrayList<Recruit>();

	private double totalMasonCommison;
	private double totalCarpenterCommison;
	private int totalMasons;
	private int totalCarpenter;
	private int totalMasonValue;
	private int totalCarpenterValue;
	private double totalHeadHunterPayment;
	
	private int masonValue=200;
	private int carpenterValue=250;
	private int groupSize=5;
	private  double commisionPercentage=0.1;
	
	private FeeProperties feeProperties = new FeeProperties();
	
	@Before
	public void init() {
		totalMasonCommison=100;
		totalCarpenterCommison=125;	
		totalMasons=7;
		totalCarpenter=7;
		totalMasonValue=1400;
		totalCarpenterValue=1750;
		totalHeadHunterPayment=3375;
		
		for(int i=0; i<totalMasons;i++) {
			Recruit r = new Recruit();
			r.setSkill("M");
			recruitList.add(r);
		}
		
		for(int i=0; i<totalCarpenter;i++) {
			Recruit r = new Recruit();
			r.setSkill("C");
			recruitList.add(r);
		}
		
		feeProperties.setCarpenterValue(carpenterValue);
		feeProperties.setMasonValue(masonValue);
		feeProperties.setGroupSize(groupSize);
		feeProperties.setCommisionPercentage(commisionPercentage);
		
		feeCalculatorComponent.setFeeProperties(feeProperties);
		feeCalculatorComponent.init();
	}
	
	@Test
	public void testCalculateTotalMasonValue() {
		int value = feeCalculatorComponent.calculateTotalMasonValue(totalMasons);
		assertThat(value).isEqualTo(totalMasonValue);
	}
	
	@Test
	public void testCalculateTotalCarpenterValue() {
		int value = feeCalculatorComponent.calculateTotalCarpenterValue(totalCarpenter);
		assertThat(value).isEqualTo(totalCarpenterValue);
	}
	
	@Test
	public void testCalculateCommisonForMason() {
		double value = feeCalculatorComponent.calculateMasonCommison(totalMasons);
		assertThat(value).isEqualTo(totalMasonCommison);
	}
	

	@Test
	public void testCalculateCommisonForCarpenter() {
		double value = feeCalculatorComponent.calculateCarpenterCommison(totalCarpenter);
		assertThat(value).isEqualTo(totalCarpenterCommison);
	}
	
	@Test
	public void testCalculateTotalHeadHunterPayment() {
		double value = feeCalculatorComponent.calculateTotalHeadhunterPayment(totalMasonValue, totalCarpenterValue, totalMasonCommison, totalCarpenterCommison);
		assertThat(value).isEqualTo(totalHeadHunterPayment);
	}
	
	@Test
	public void testCalculateNumberOfRecruits() {
		HeadHunterFeeDto feeDto = feeCalculatorComponent.getTotalCountOfMasonAndCarpenters(recruitList);
		assertThat(totalCarpenter).isEqualTo(feeDto.getTotalCarpenters());
		assertThat(totalMasons).isEqualTo(feeDto.getTotalMasons());
	}
	
	@Test
	public void testCalculateMasonCommisonByGroupSize() {
		feeProperties.setGroupSize(8);
		feeCalculatorComponent.setFeeProperties(feeProperties);
		feeCalculatorComponent.init();
		double value = feeCalculatorComponent.calculateMasonCommison(8);
		assertThat(value).isEqualTo(160);		
	}
	
	
	@Test
	public void testCalculateCarpenterCommisonByGroupSize() {
		feeProperties.setGroupSize(8);
		feeCalculatorComponent.setFeeProperties(feeProperties);
		feeCalculatorComponent.init();
		double value = feeCalculatorComponent.calculateCarpenterCommison(8);
		assertThat(value).isEqualTo(200);		
	}

	// Total Masons 5
	@Test
	public void testCalculateTotalMasonValueForFive() {
		int value = feeCalculatorComponent.calculateTotalMasonValue(5);
		assertThat(value).isEqualTo(1000);
	}

	// Total Carpenter 5
	@Test
	public void testCalculateTotalCarpenterValueForFive() {
		int value = feeCalculatorComponent.calculateTotalCarpenterValue(5);
		assertThat(value).isEqualTo(1250);
	}

	/* Total mason 5
	 * Expected Comission 100
	*/
	@Test
	public void testCalculateCommisonForFiveMason() {
		double value = feeCalculatorComponent.calculateMasonCommison(5);
		assertThat(value).isEqualTo(100);
	}
	
	/* Total mason 5
	 * Expected Comission 100
	*/
	@Test
	public void testCalculateCommisonForFiveCarpenter() {
		double value = feeCalculatorComponent.calculateCarpenterCommison(5);
		assertThat(value).isEqualTo(125);
	}

}
