package com.testsoft.feecalc.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.Recruit;

@Component("feeCalculatorComponent")
public class FeeCalculatorComponent {
	
	@Autowired
	private FeeProperties feeProperties;
	
	private  int masonValue;
	private  int carpenterValue;
	private  int groupSize;
	private  double commisionPercentage;
	
	@PostConstruct
	public void init() {
		 masonValue = feeProperties.getMasonValue();
		 carpenterValue = feeProperties.getCarpenterValue();
		 groupSize = feeProperties.getGroupSize();
		 commisionPercentage = feeProperties.getCommisionPercentage();
	}
	
	
	public HeadHunterFeeDto getTotalCountOfMasonAndCarpenters(List<Recruit> recruitList) {
		int totalMasons = 0;      //Total no of masons Recruited
		int totalCarpenters = 0; //Total no of Carpenters Recruited
		
		for (Recruit recruit : recruitList) {
			if(recruit.getSkill().equals("M")) {				
				totalMasons++;
			}else {				
				totalCarpenters++;
			}
		}
		
		HeadHunterFeeDto feeDto = new HeadHunterFeeDto();  
		feeDto.setTotalCarpenters(totalCarpenters);
		feeDto.setTotalMasons(totalMasons);
		return feeDto;		
	}
	
	
	
	public int calculateTotalMasonValue(int totalMasons) {
		int totalMasonValue = totalMasons*this.masonValue;
		return totalMasonValue;
	}
	
	
	public double calculateCommison(int recuritmentValue,int totalRecruitments) {
		double commison = (totalRecruitments-(totalRecruitments % this.groupSize))* recuritmentValue * this.commisionPercentage;
		return commison;
	}
	
	public double calculateCarpenterCommison(int totalCarpenters) {
		double carpenterComission = (totalCarpenters-(totalCarpenters % this.groupSize))* this.carpenterValue * this.commisionPercentage;
		return carpenterComission;
	}
	
	public double calculateMasonCommison(int totalMasons) {
		double masonCommison = (totalMasons-(totalMasons % this.groupSize))* this.masonValue * this.commisionPercentage;
		return masonCommison;
	}
	
	public int calculateTotalCarpenterValue(int totalCarpenters) {
		int totalCarpenterValue=totalCarpenters*this.carpenterValue;
		return totalCarpenterValue;
	}
	
	public double calculateTotalHeadhunterPayment(int totalMasonValue,int totalCarpenterValue,double  masonCommison,double carpenterComission) {
		double totalHeadhunterPaymentValue = totalMasonValue+totalCarpenterValue+ masonCommison + carpenterComission;
		return totalHeadhunterPaymentValue;
	}
	
	
	public HeadHunterFeeDto calculateHeadHunterFee(List<Recruit> recruitList) {
		
		HeadHunterFeeDto feeDto = getTotalCountOfMasonAndCarpenters(recruitList);
				
		//Total no of masons Recruited
		int totalMasons = feeDto.getTotalMasons();    
		
		//Total no of Carpenters Recruited
		int totalCarpenters =  feeDto.getTotalCarpenters(); 
		
		//Total payment value for mason count
		int totalMasonValue = calculateTotalMasonValue(totalMasons);  
		
		//Total payment value for carpenter count
		int totalCarpenterValue = calculateTotalCarpenterValue(totalCarpenters);  
		
		//Commisson for mason count
		//double masonCommison=calculateMasonCommison(totalMasons);   
		double masonCommison= calculateCommison(this.masonValue,totalMasons); 
		
		//Commisson for carpenter count
		//double carpenterComission=calculateCarpenterCommison(totalCarpenters); 
		double carpenterComission= calculateCommison(this.carpenterValue,totalCarpenters);
		
		
		
		//Total payment value
		double totalHeadhunterPaymentValue = calculateTotalHeadhunterPayment(totalMasonValue, totalCarpenterValue, masonCommison, carpenterComission);         
		
		
		feeDto.setTotalCarpenterCommison(carpenterComission);
		feeDto.setTotalMasonCommison(masonCommison);
		feeDto.setTotalMasonValue(totalMasonValue);
		feeDto.setTotalCarpenterValue(totalCarpenterValue);
		feeDto.setTotalValue(totalHeadhunterPaymentValue);
		return feeDto;
	}


	public FeeProperties getFeeProperties() {
		return feeProperties;
	}


	public void setFeeProperties(FeeProperties feeProperties) {
		this.feeProperties = feeProperties;
	}
	
	
}
