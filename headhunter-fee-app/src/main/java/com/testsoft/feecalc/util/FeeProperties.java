package com.testsoft.feecalc.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties(prefix="fee")
public class FeeProperties {
	
	private int masonValue;
	private int carpenterValue;
	private int groupSize;
	private  double commisionPercentage;
	
	public int getMasonValue() {
		return masonValue;
	}
	public void setMasonValue(int masonValue) {
		this.masonValue = masonValue;
	}
	public int getCarpenterValue() {
		return carpenterValue;
	}
	public void setCarpenterValue(int carpenterValue) {
		this.carpenterValue = carpenterValue;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public double getCommisionPercentage() {
		return commisionPercentage;
	}
	public void setCommisionPercentage(double commisionPercentage) {
		this.commisionPercentage = commisionPercentage;
	}
	@Override
	public String toString() {
		return "FeeProperties [masonValue=" + masonValue + ", carpenterValue=" + carpenterValue + ", groupSize="
				+ groupSize + ", commisionPercentage=" + commisionPercentage + "]";
	}
	
	
	

}
