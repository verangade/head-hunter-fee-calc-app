package com.testsoft.feecalc.repository;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.testsoft.feecalc.controller.HeadHunterController;
import com.testsoft.feecalc.model.HeadHunter;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HeadHunterRepositoryTest {
	
	@Autowired
	private HeadHunterRepository headHunterRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(HeadHunterRepositoryTest.class);
	
	
	@Test
	public void findAllHeadHunters() {
		List<HeadHunter> list = headHunterRepository.findAll();
		System.out.println(list);
		logger.info(list.toString());
		assertNotNull(list);
	}
	

}
