package com.testsoft.feecalc.dto;

public class HeadHunterFeeDto {
	
	private double totalMasonCommison = 0;
	private double totalCarpenterCommison = 0;
	
	private int totalMasons = 0;
	private int totalCarpenters = 0;
	
	private int totalMasonValue = 0;
	private int totalCarpenterValue = 0;
	
	private double totalValue;
	
	
	public HeadHunterFeeDto() {
		super();
	}

	

	public HeadHunterFeeDto(double totalMasonCommison, double totalCarpenterCommison, int totalMasons,
			int totalCarpenters, int totalMasonValue, int totalCarpenterValue, double totalValue) {
		super();
		this.totalMasonCommison = totalMasonCommison;
		this.totalCarpenterCommison = totalCarpenterCommison;
		this.totalMasons = totalMasons;
		this.totalCarpenters = totalCarpenters;
		this.totalMasonValue = totalMasonValue;
		this.totalCarpenterValue = totalCarpenterValue;
		this.totalValue = totalValue;
	}



	public double getTotalMasonCommison() {
		return totalMasonCommison;
	}


	public void setTotalMasonCommison(double totalMasonCommison) {
		this.totalMasonCommison = totalMasonCommison;
	}


	public double getTotalCarpenterCommison() {
		return totalCarpenterCommison;
	}


	public void setTotalCarpenterCommison(double totalCarpenterCommison) {
		this.totalCarpenterCommison = totalCarpenterCommison;
	}


	public int getTotalMasons() {
		return totalMasons;
	}


	public void setTotalMasons(int totalMasons) {
		this.totalMasons = totalMasons;
	}


	public int getTotalCarpenters() {
		return totalCarpenters;
	}


	public void setTotalCarpenters(int totalCarpenters) {
		this.totalCarpenters = totalCarpenters;
	}


	public int getTotalMasonValue() {
		return totalMasonValue;
	}


	public void setTotalMasonValue(int totalMasonValue) {
		this.totalMasonValue = totalMasonValue;
	}


	public int getTotalCarpenterValue() {
		return totalCarpenterValue;
	}


	public void setTotalCarpenterValue(int totalCarpenterValue) {
		this.totalCarpenterValue = totalCarpenterValue;
	}


	public double getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}



	@Override
	public String toString() {
		return "HeadHunterFeeDto [totalMasonCommison=" + totalMasonCommison + ", totalCarpenterCommison="
				+ totalCarpenterCommison + ", totalMasons=" + totalMasons + ", totalCarpenters=" + totalCarpenters
				+ ", totalMasonValue=" + totalMasonValue + ", totalCarpenterValue=" + totalCarpenterValue
				+ ", totalValue=" + totalValue + "]";
	}
	
	

}
