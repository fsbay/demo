package com.fsbay.frame.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsbay.frame.entity.User;
import com.fsbay.frame.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody User entity) {
		try {
			userService.save(entity);
			return "ok";
		} catch (Exception e) {
			logger.error("", e);
			return "error";
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public List<User> get() {
		try {
			User entity =  new User();
			entity.setAge(1);
			entity.setEmail("a@tom.com");
			entity.setId(2L);
			entity.setName("fuck");
			List<User> users = userService.list();
			return users;
		} catch (Exception e) {
			logger.error("", e);
			return new ArrayList<User>();
		}
	}
}
