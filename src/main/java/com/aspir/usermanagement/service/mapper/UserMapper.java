package com.aspir.usermanagement.service.mapper;

import org.springframework.stereotype.Component;

import com.aspir.usermanagement.expcetion.BadRequestException;
import com.aspir.usermanagement.expcetion.CustomeApplicationException;
import com.aspir.usermanagement.repository.entity.UserEntity;
import com.aspir.usermanagement.service.dto.UserRequestDTO;
import com.aspir.usermanagement.service.dto.UserResponceDTO;
import com.aspir.usermanagement.util.DateUtil;


@Component
public class UserMapper {

	public UserEntity toEntity(UserRequestDTO userRequestDTO) {
		if (userRequestDTO == null) {
			throw new BadRequestException("user request dto must be requirede");
		}
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userRequestDTO.getFirstName());
		userEntity.setLastName(userRequestDTO.getLastNmae());
		userEntity.setEmailId(userRequestDTO.getEmail());
		userEntity.setMobileNumber(userRequestDTO.getMobileNumber());
		userEntity.setPassword(userRequestDTO.getPassword());
		userEntity.setDataOfBirth(DateUtil.toLocalDate(userRequestDTO.getDateOfBirth()));

		return userEntity;
	}
	
	public UserResponceDTO toDto(UserEntity userEntity) {
		
		if (userEntity == null) {
			throw new CustomeApplicationException("user entity must be not null");
		}
		
		UserResponceDTO userResponceDTO = new UserResponceDTO();
		userResponceDTO.setFirstName(userEntity.getFirstName());
		userResponceDTO.setLastNmae(userEntity.getLastName());
		userResponceDTO.setEmail(userEntity.getEmailId());
		userResponceDTO.setMobileNumber(userEntity.getMobileNumber());
		userResponceDTO.setPassword(userEntity.getPassword());
		userResponceDTO.setDateOfBirth(DateUtil.toString(userEntity.getDataOfBirth()));
		
		return userResponceDTO;
	}

	
	
}
