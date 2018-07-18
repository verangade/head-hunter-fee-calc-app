package com.testsoft.feecalc.service;

import java.util.Date;
import java.util.List;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;


public interface HeadHunterService {
	
	public HeadHunter findHeadHunterById(long headHunterId);
	public List<HeadHunter> findAllHeadHunters();
	public List<Recruit> findRecruitsByHeadHunter(long headHunterId);
	public List<Recruit> findRecruitsByHeadHunter(HeadHunter headHunter);
	public List<Recruit> findRecruitsByHeadHunterIdAndJoinedDate(long headHunterId,Date joinedDate);
	public HeadHunterFeeDto calculateHeadHunterFee(List<Recruit> recruitList);

}
