package com.fsbay.frame.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsbay.frame.entity.User;
import com.fsbay.frame.entity.Users;
import com.fsbay.frame.service.UsersService;
import com.fsbay.frame.utils.Mock;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String insert() {
		try {
			Users users = Mock.mockUsers();
			usersService.save(users);
			return "ok";
		} catch (Exception e) {
			logger.error("", e);
			return "error";
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> get() {
		try {
			User entity =  new User();
			entity.setAge(1);
			entity.setEmail("a@tom.com");
			entity.setId(2L);
			entity.setName("fuck");
			List<Users> users = usersService.list();
			return users;
		} catch (Exception e) {
			logger.error("", e);
			return new ArrayList<Users>();
		}
	}
	
	
	@RequestMapping(value = "/getPage", method = RequestMethod.GET)
	@ResponseBody
	public List<Users> getPage() {
		try {
			Page<Users> page = new Page<>(1, 1000);
			IPage<Users> userIPage = usersService.page(page, null);
			return userIPage.getRecords();
		} catch (Exception e) {
			logger.error("", e);
			return new ArrayList<Users>();
		}
	}
}
