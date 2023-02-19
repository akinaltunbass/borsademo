package com.project.borsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.borsa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
