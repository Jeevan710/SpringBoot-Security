package com.spring.security.Security.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.Security.entity.Erole;
import com.spring.security.Security.entity.RoleEntity;

@Repository
public interface RoleDAO extends JpaRepository<RoleEntity,Long>{
	Optional<RoleEntity> findByRole(Erole role);
}
