package com.training.ratings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.ratings.entity.Development;

@Repository
public interface DevelopmentRepository extends JpaRepository<Development, Long> {
   List<Development> findByPoliticalLeaderId(Long politicalLeaderId);
}
