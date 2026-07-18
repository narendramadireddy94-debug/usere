package com.aspir.usermanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aspir.usermanagement.expcetion.UserNotFoundException;
import com.aspir.usermanagement.repository.UserEntityRepository;
import com.aspir.usermanagement.repository.entity.UserEntity;
import com.aspir.usermanagement.service.UserService;
import com.aspir.usermanagement.service.dto.UserRequestDTO;
import com.aspir.usermanagement.service.dto.UserResponceDTO;
import com.aspir.usermanagement.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	private final UserEntityRepository userEntityRepository;

	public UserServiceImpl(UserMapper userMapper, UserEntityRepository userEntityRepository) {
		super();
		this.userMapper = userMapper;
		this.userEntityRepository = userEntityRepository;
	}

	@Override
	public Long insertUser(UserRequestDTO userRequestDTO) {
		UserEntity userEntity = userMapper.toEntity(userRequestDTO);
		if (userEntity != null) {
			UserEntity saveduseUserEntity = userEntityRepository.save(userEntity);
			return saveduseUserEntity.getUserId();
		}
		return null;
	}

	@Override
	public UserResponceDTO getUser(Long userId) {
		Optional<UserEntity> optionaluser = userEntityRepository.findById(userId);
		if (optionaluser.isEmpty()) {
			throw new UserNotFoundException("user details not found for given user id" + userId);
		}
		return userMapper.toDto(optionaluser.get());
	}

	@Override
	public List<UserResponceDTO> getUsers() {
		List<UserResponceDTO> users = new ArrayList<>();
		List<UserEntity> userslList = userEntityRepository.findAll();
		if (userslList != null) {
			for (UserEntity userEntity : userslList) {

				users.add(userMapper.toDto(userEntity));
			}
		}
		return null;
	}

	@Override
	public void updateUser(Long userId, UserRequestDTO userRequestDTO) {
		
	Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
	if(optionalUser.isPresent()) {
		
		UserEntity userEntity = userMapper.toEntity(userRequestDTO);
		
		userEntity.setUserId(userId);
		userEntityRepository.save(userEntity);
	}
	else {
		throw new UserNotFoundException("user detatils not found for given user id"+ userId);
	}
	

	}

	@Override
	public void deleteUser(Long userId) {
		Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("user details not found for given user id" + userId);
		}
		
		userEntityRepository.delete(optionalUser.get());
	}

}
