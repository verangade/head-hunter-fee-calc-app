package com.testsoft.feecalc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recruit {

	@Id
	private Long personId;
	private String firstName;
	private String lastName;
	private int phone;
	private String skill;
	private Date joinedDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "head_hunter_id")
	private HeadHunter headHunter;
		
	
	public Recruit() {
		
	}
	
	public Long getRecruiterId() {
		return personId;
	}
	
	public Recruit(Long recruiterId, String firstName, String lastName, int phone, String skill, Date joinedDate,
			HeadHunter headHunter) {
		super();
		this.personId = recruiterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.skill = skill;
		this.joinedDate = joinedDate;
		this.headHunter = headHunter;
	}
	public void setRecruiterId(Long recruiterId) {
		this.personId = recruiterId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public HeadHunter getHeadHunter() {
		return headHunter;
	}
	public void setHeadHunter(HeadHunter headHunter) {
		this.headHunter = headHunter;
	}


	@Override
	public String toString() {
		return "Recruit [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", skill=" + skill + ", joinedDate=" + joinedDate + ", headHunter=" + headHunter + "]";
	}
	
	
	
	
	
}
