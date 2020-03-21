package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.User;

@Repository
public interface SignupRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

}
