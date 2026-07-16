package com.aspir.usermanagement.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Repository
public interface UserEntityRepositor extends JpaRepository<UserEntity, Long>{

}
