package com.aspir.usermanagement.repository.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "USER_TL")
public class UaerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID",length = 30,nullable = false)
	private Long userId;
	@Column(name = "USER_NAME",length = 30,nullable = false)
	private String userName;
	@Column(name ="USER_FIRST_NAME",length = 35,nullable = false)
	private String userFirstName;
	@Column(name ="USER_LAST_NAME" , length = 30,nullable = false)
	private String userLastName;
	@Column(name = "EMAIL_ID",length = 30,nullable = false,unique = true)
	private String emailId;
	@Column(name = "PASSWORD",length = 34,nullable = false)
	private String password;
	@Column(name ="MOBILE_NUMBER" ,length = 10,nullable = false)
	private String mobileNumber;
	@Column(name ="DATE_OF_BIRTH",nullable = false)
	private LocalDate dateOfBirth;
	
}
