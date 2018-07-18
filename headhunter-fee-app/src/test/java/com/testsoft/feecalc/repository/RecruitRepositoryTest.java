package com.testsoft.feecalc.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.testsoft.feecalc.model.Recruit;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RecruitRepositoryTest {
	
	@Autowired
	private HeadHunterRepository headHunterRepository;
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	private int headHunterId;
	private int recruitmentCount=14;
	
	
	@Before
	public void setUP() {
		headHunterId=10001;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(RecruitRepositoryTest.class);
	
	@Test
	public void findByHeadHunterIdAndJoinedDateTest() {
		List<Recruit> list = recruitRepository.findByHeadHunterIdAndJoinedDate(headHunterId);
		logger.debug(""+list.size());
		assertThat(list.size()).isEqualTo(recruitmentCount);
	}

}
