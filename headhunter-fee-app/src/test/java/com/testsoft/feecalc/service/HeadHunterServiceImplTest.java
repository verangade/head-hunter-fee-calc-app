package com.testsoft.feecalc.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.testsoft.feecalc.dto.HeadHunterFeeDto;
import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;
import com.testsoft.feecalc.repository.RecruitRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeadHunterServiceImplTest {
	
	@TestConfiguration
	static class HeadHunterServiceImplTestContextConfiguration {
		  
		@Bean
		public static HeadHunterService headhunterService() {
			return new HeadHunterServiceImpl();
		}
    }
	
	@Autowired
	private HeadHunterService headhunterService;
		
	@MockBean
	private RecruitRepository recruitRepository;
	
	private List<Recruit> recruitList = new ArrayList<Recruit>();
	
	@Before
	public void setup() {
		
		Recruit recruit1 = new Recruit();
		recruit1.setFirstName("Jhon");
		recruit1.setLastName("Doe");
		recruit1.setPhone(0711234567);
		recruit1.setSkill("M");
		
		Recruit recruit2 = new Recruit();
		recruit2.setFirstName("Jane");
		recruit2.setLastName("Doe");
		recruit2.setPhone(0721234567);
		recruit2.setSkill("C");
	
		
		this.recruitList.add(recruit1);
		this.recruitList.add(recruit2);
		Mockito.when(recruitRepository.findByHeadHunterIdAndJoinedDate(1111)).thenReturn(recruitList);
	}
	
	@Test 
	public void findByHeadHunterIdAndJoinedDateTest() {
		
		List<Recruit> recruitList = headhunterService.findRecruitsByHeadHunterIdAndJoinedDate(1111, null);
		assertThat(recruitList.size()).isEqualTo(2);
	}
	
	@Test
	public void calculateHeadHunterFeeTest() {
		HeadHunterFeeDto feeDto = headhunterService.calculateHeadHunterFee(recruitList);
		assertThat(feeDto).isNotNull();
	}
	
	@Test
	public void findHeadHunterByIdTest() {
		int headHunterId = 111;
		HeadHunter headHunter = headhunterService.findHeadHunterById(headHunterId);
		assertThat(headHunter).isNotNull();
	}
	
	
}
