package com.project.borsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.borsa.model.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {
	
	List<Share> findByUserId(Long userId);
}
