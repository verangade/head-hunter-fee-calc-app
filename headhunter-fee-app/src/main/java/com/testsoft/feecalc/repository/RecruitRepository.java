package com.testsoft.feecalc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.testsoft.feecalc.model.HeadHunter;
import com.testsoft.feecalc.model.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
	
	//public List<Recruit> findByHeadHunter(long headHunterId);
	
	public List<Recruit> findByHeadHunter(HeadHunter headHunter);
	
//	@Query(value="select * from recruit where head_hunter_id=:headHunterId and Month(Joined_date)=Month(CURRENT_DATE())",nativeQuery=true)
//	public List<Recruit> findByHeadHunterIdAndJoinedDate(@Param("headHunterId") long headHunterId,Date date);
	
	@Query(value="select * from recruit where head_hunter_id=:headHunterId and Month(Joined_date)=Month(CURRENT_DATE()) and Year(Joined_date)=Year(CURRENT_DATE())",nativeQuery=true)
	public List<Recruit> findByHeadHunterIdAndJoinedDate(@Param("headHunterId") long headHunterId);
}
