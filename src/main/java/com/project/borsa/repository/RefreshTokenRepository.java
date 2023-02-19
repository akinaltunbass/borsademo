package com.project.borsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.borsa.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	
	RefreshToken findByUserId(Long userId);

}
