package com.aspir.usermanagement.service;

import java.util.List;

import com.aspir.usermanagement.service.dto.UserRequestDTO;
import com.aspir.usermanagement.service.dto.UserResponceDTO;

public interface UserService {

	
	public Long insertUser(UserRequestDTO userRequestDTO);
	
	public UserResponceDTO getUser(Long userId);
	
	public List<UserResponceDTO> getUsers();
	
	public void updateUser(Long userId , UserRequestDTO userRequestDTO);
	
	public void deleteUser(Long userId);
	
	
}
