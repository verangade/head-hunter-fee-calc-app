package com.testsoft.feecalc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;
import com.testsoft.feecalc.repository.HeadHunterRepository;
import com.testsoft.feecalc.repository.RecruitRepository;
import com.testsoft.feecalc.util.FeeCalculatorComponent;

@Service
public class HeadHunterServiceImpl implements HeadHunterService {
	
	@Autowired
	private FeeCalculatorComponent feeCalculatorComponent;
	
	@Autowired
	private HeadHunterRepository headHunterRepository;
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@Override
	public List<HeadHunter> findAllHeadHunters() {
		return headHunterRepository.findAll();
	}

	@Override
	public List<Recruit> findRecruitsByHeadHunter(long headHunterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recruit> findRecruitsByHeadHunter(HeadHunter headHunter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recruit> findRecruitsByHeadHunterIdAndJoinedDate(long headHunterId, Date joinedDate) {
		return recruitRepository.findByHeadHunterIdAndJoinedDate(headHunterId);
	}

	/**
	 * This method will calculate the Total Fee
	 */
	@Override
	public HeadHunterFeeDto calculateHeadHunterFee(List<Recruit> recruitList) {
		
		return feeCalculatorComponent.calculateHeadHunterFee(recruitList);

	}

	@Override
	public HeadHunter findHeadHunterById(long headHunterId) {
		return headHunterRepository.getOne(headHunterId);
	}

}
