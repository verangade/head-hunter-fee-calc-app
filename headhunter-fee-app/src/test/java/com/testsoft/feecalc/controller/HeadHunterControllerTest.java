package com.testsoft.feecalc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;
import com.testsoft.feecalc.service.HeadHunterService;

@RunWith(SpringRunner.class)
@WebMvcTest(HeadHunterController.class)
public class HeadHunterControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private HeadHunterService headhunterService;
	
	//@Ignore
	@Test
	public void getAllHeadHuntersTest() throws Exception {
		HeadHunter headHunter = new HeadHunter();
		List<HeadHunter> headHunterList = Arrays.asList(headHunter);
		Mockito.when(headhunterService.findAllHeadHunters()).thenReturn(headHunterList);
		mvc.perform(get("/headhunter")).andExpect(status().isOk());
	}

	//@Ignore
	@Test
	public void getRecruitmentsByHeadHunterIdTest() throws Exception {
		
		int headHunterId = 111;
		Recruit recruit = new Recruit();
		List<Recruit> recruitList =  Arrays.asList(recruit);
		HeadHunter headHunter = new HeadHunter();
		Mockito.when( headhunterService.findRecruitsByHeadHunterIdAndJoinedDate(headHunterId,null)).thenReturn(recruitList);		
		Mockito.when(headhunterService.findHeadHunterById(headHunterId)).thenReturn(headHunter);
		
		mvc.perform(get("/headhunter/"+headHunterId+"/recruitments")).andExpect(status().isOk());
	}
	
	@Test
	public void calculateHeadHunterFeeTest() throws Exception {
		
		int headHunterId = 111;
		Recruit recruit = new Recruit();
		HeadHunterFeeDto feeDto = new HeadHunterFeeDto();
		HeadHunter headHunter = new HeadHunter();
		List<Recruit> recruitList =  Arrays.asList(recruit);		
		Mockito.when( headhunterService.findRecruitsByHeadHunterIdAndJoinedDate(headHunterId,null)).thenReturn(recruitList);
		Mockito.when( headhunterService.calculateHeadHunterFee(recruitList)).thenReturn( feeDto);
		Mockito.when(headhunterService.findHeadHunterById(headHunterId)).thenReturn(headHunter);
		
		mvc.perform(get("/headhunter/"+headHunterId+"/calculate")).andExpect(status().isOk());
	}
	
	
}
