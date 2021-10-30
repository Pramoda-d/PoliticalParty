package com.training.ratings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ratings.entity.PoliticalLeader;

@Repository
public interface PoliticalLeaderRepository extends JpaRepository<PoliticalLeader, Long> {
	List<PoliticalLeader> findByPoliticalPartyId(Long politicalPartyId);
}
