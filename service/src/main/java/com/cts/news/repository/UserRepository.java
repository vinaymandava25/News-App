package com.cts.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(@Param(value = "us_name") String name);

	User findByEmail(@Param(value = "us_email") String email);

	public List<User> findUserNames(@Param("searchUserName") String searchUserName);

	User findById(int id);


}
