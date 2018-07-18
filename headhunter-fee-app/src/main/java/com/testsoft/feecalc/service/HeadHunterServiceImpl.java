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

@Service
public class HeadHunterServiceImpl implements HeadHunterService {
	
	private final int masonValue = 200;
	private final int carpenterValue = 250;
	private final int groupSize = 5;
	private final double commisionPercentage = 0.1;

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
		int totalMasonValue = 0;  //Total payment value for mason count
		int totalCarpenterValue = 0;  //Total payment value for carpenter count
		
		int totalMasons = 0;      //Total no of masons Recruited
		int totalCarpenters = 0; //Total no of Carpenters Recruited
		
		double masonCommison=0;        //Commisson for mason count
		double carpenterComission=0;   //Commisson for carpenter count
		double totalValue = 0;         //Total payment value
		
		for (Recruit recruit : recruitList) {
			if(recruit.getSkill().equals("M")) {
				totalMasonValue+= masonValue;
				totalMasons++;
			}else {
				totalCarpenterValue+=carpenterValue;
				totalCarpenters++;
			}
		}
		
		masonCommison = (totalMasons-(totalMasons % groupSize))* masonValue * commisionPercentage;
		carpenterComission = (totalCarpenters-(totalCarpenters % groupSize))* carpenterValue * commisionPercentage;
		
		totalValue = totalMasonValue+totalCarpenterValue+ masonCommison + carpenterComission;
		
		HeadHunterFeeDto feeDto = new HeadHunterFeeDto();  
		feeDto.setTotalCarpenterCommison(carpenterComission);
		feeDto.setTotalMasonCommison(masonCommison);
		feeDto.setTotalCarpenters(totalCarpenters);
		feeDto.setTotalMasons(totalMasons);
		feeDto.setTotalMasonValue(totalMasonValue);
		feeDto.setTotalCarpenterValue(totalCarpenterValue);
		feeDto.setTotalValue(totalValue);
		return feeDto;
	}

	@Override
	public HeadHunter findHeadHunterById(long headHunterId) {
		return headHunterRepository.getOne(headHunterId);
	}

}
