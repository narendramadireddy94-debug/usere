package com.aspir.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspir.usermanagement.repository.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

}
