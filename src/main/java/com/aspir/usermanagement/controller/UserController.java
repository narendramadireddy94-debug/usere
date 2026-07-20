package com.aspir.usermanagement.controller;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspir.usermanagement.service.UserService;
import com.aspir.usermanagement.service.dto.ComamonResponceDTO;
import com.aspir.usermanagement.service.dto.UserRequestDTO;
import com.aspir.usermanagement.service.dto.UserResponceDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/insertuser")
	public ResponseEntity<ComamonResponceDTO<Long>> insertUser(@RequestBody UserRequestDTO userRequestDTO) {

		Long userId = userService.insertUser(userRequestDTO);

		ComamonResponceDTO<Long> comamonResponceDTO = new ComamonResponceDTO<>();

		comamonResponceDTO.setData(userId);
		comamonResponceDTO.setStatus(HttpStatus.CREATED.value());
		comamonResponceDTO.setMassage("User details sucessfully save");
		comamonResponceDTO.setTimeStamp(LocalDateTime.now());

		return new ResponseEntity<>(comamonResponceDTO, HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<ComamonResponceDTO<List<UserResponceDTO>>> getUsers() {

		List<UserResponceDTO> users = userService.getUsers();
		
		ComamonResponceDTO<List<UserResponceDTO>> comamonResponceDTO = new ComamonResponceDTO<>();
		comamonResponceDTO.setData(users);
		comamonResponceDTO.setStatus(HttpStatus.CREATED.value());
		comamonResponceDTO.setMassage("User details sucess");
		comamonResponceDTO.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<> (comamonResponceDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<ComamonResponceDTO<UserResponceDTO>> getUser(@PathVariable("userId") Long userId){
		
		UserResponceDTO userResponceDTO = userService.getUser(userId);
		
		ComamonResponceDTO<UserResponceDTO> comamonResponceDTO = new ComamonResponceDTO<>();
		
		comamonResponceDTO.setData(userResponceDTO);
		comamonResponceDTO.setStatus(HttpStatus.OK.value());
		comamonResponceDTO.setMassage("user details sucessufuly fetched based on user id");
		comamonResponceDTO.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<> (comamonResponceDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId ,@RequestBody UserRequestDTO userRequestDTO){
		
		userService.updateUser(userId, userRequestDTO);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
	@DeleteMapping("/deleteuser")
	public ResponseEntity<Void> deleteUser(@RequestParam("userId") Long userId){
		
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
}
