/**
 * 
 */
package com.fsbay.frame.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fsbay.frame.entity.Users;
import com.fsbay.frame.mapper.UsersMapper;
import com.fsbay.frame.service.UsersService;

/**
 * @author John
 *
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
