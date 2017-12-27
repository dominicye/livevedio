package com.ways.live.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ways.live.data.UserRepository;
import com.ways.live.model.User;

import java.util.Date;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User getUser(String userName, String passWord)
	{
		return userRepository.getUser(userName,passWord);
	}

	public User createUser(String cellPhone, String password, String userName) throws Exception
	{
		User user = new User();
		user.setName(userName);
		user.setCellPhone(cellPhone);
		user.setPassword(password);
		user.setRegisterTime(new Date());

		return userRepository.save(user);
	}
}
