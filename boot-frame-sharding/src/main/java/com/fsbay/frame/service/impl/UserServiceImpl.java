/**
 * 
 */
package com.fsbay.frame.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fsbay.frame.entity.User;
import com.fsbay.frame.mapper.UserMapper;
import com.fsbay.frame.service.UserService;

/**
 * @author John
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
