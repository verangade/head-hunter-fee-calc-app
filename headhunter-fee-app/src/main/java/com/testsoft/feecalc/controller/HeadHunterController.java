package com.testsoft.feecalc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;
import com.testsoft.feecalc.service.HeadHunterService;

@Controller
@RequestMapping("/headhunter")
public class HeadHunterController {
	
	@Autowired
	private HeadHunterService headhunterService;
	
	private static final Logger logger = LoggerFactory.getLogger(HeadHunterController.class);

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getAllHeadHunters(Model model) {
		logger.info("Getting All headhunters");
		List<HeadHunter> headHunterList = headhunterService.findAllHeadHunters();
		model.addAttribute("headHunterList", headHunterList);
		return "headhunter";
	}
	
	/**
	 * 
	 * @param headHunterId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{headHunterId}/recruitments" , method=RequestMethod.GET)
	public String getRecruitmentsByHeadHunterId(@PathVariable long headHunterId,Model model) {
		
		logger.info("Getting recruitements made by the headhunter for the current month and current year");
		List<Recruit> recruitList = headhunterService.findRecruitsByHeadHunterIdAndJoinedDate(headHunterId,null);
		HeadHunter headHunter = headhunterService.findHeadHunterById(headHunterId);
		model.addAttribute("headHunter",headHunter);
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("headHunterId", headHunterId);
		model.addAttribute("todayDate",java.time.LocalDate.now());
		return "recruitments";
	}
	
	@RequestMapping(value="/{headHunterId}/calculate" , method=RequestMethod.GET)
	public String calculateHeadHunterFee(@PathVariable long headHunterId,Model model) {
		logger.info("Calculate headhunter Fee");
		
		List<Recruit> recruitList = headhunterService.findRecruitsByHeadHunterIdAndJoinedDate(headHunterId,null);		
		
		HeadHunterFeeDto feeDto = headhunterService.calculateHeadHunterFee(recruitList);
		HeadHunter headHunter = headhunterService.findHeadHunterById(headHunterId);
		model.addAttribute("headHunter",headHunter);
		model.addAttribute("todayDate",java.time.LocalDate.now());
		logger.debug(feeDto.toString());
		model.addAttribute("feeDto", feeDto);
		return "fee";
	}
	
	
}
