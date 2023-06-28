package com.spring.security.Security.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.Security.entity.UserEntity;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long>{
	UserEntity findByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByEmail(String email);
}
