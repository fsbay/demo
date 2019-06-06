package com.fsbay.frame.utils;

import java.util.Date;

import com.fsbay.frame.entity.Users;

import cn.hutool.core.util.RandomUtil;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;

public class Mock {

	private static DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();

	public static int channels_size = 200;
	public static int game_size = 300;
	public static int top_size = 100;

	protected static String[] channels = null;
	protected static String[] games = null;
	protected static String tops[] = null;

	public static String userTypes[] = { "annoy", "qq", "weixin", "ordinary" };
	static {
		channels = make(channels_size, "channel");
		games = make(game_size, "game");
		tops = make(top_size, "top");
		DefaultKeyGenerator.setWorkerId(RandomUtil.randomLong(1, 1024));
	}

	public static String randomId() {
		return String.valueOf(keyGenerator.generateKey().longValue());
	}

	public static Users mockUsers() {
		String randomId = randomId();
		String channel = Mock.randomEleByGame();
		String clientId = Mock.randomEleByChannel();
		String deviceId = randomId();
		String mail = "cc" + randomId + "@163.com";
		String nickname = "陈" + randomId;
		String openId = "openID_" + randomId;
		String phone = "0731" + "" + randomId;
		String password = "6880918e4a4b5a4ed50fa70f3ae81ad3";
		String username = "cc" + randomId;
		String userType = RandomUtil.randomEle(Mock.userTypes);
		Users s = new Users();
		s.setArchived(0);
		s.setAvatorUrl(null);
		s.setCreateTime(new Date());
		s.setDefaultUser(0);
		s.setGuid(randomId());
		s.setDescription(null);
		s.setChannel(channel);
		s.setClientId(clientId);
		s.setDeviceId(deviceId);
		s.setMail(mail);
		s.setNickname(nickname);
		s.setOpenId(openId);
		s.setPhone(phone);
		s.setPassword(password);
		s.setUsername(username);
		s.setUserType(userType);
		s.setImageCount(0L);
		s.setIstest(0);
		s.setLastLoginTime(new Date());
		s.setTemplateCount(0L);
		s.setVersion(0);
		return s;

	}

	
	public static String randomEleByGame() {
		return RandomUtil.randomEle(games);
	}

	public static String randomEleByChannel() {
		return RandomUtil.randomEle(channels);
	}

	public static String randomEleByGameTop() {
		return RandomUtil.randomEle(tops);
	}

	public static String[] make(int size, String prfix) {
		String[] rs = new String[size];
		int index = 0;
		while (index < size) {
			rs[index] = prfix + "_" + index;
			index++;
		}
		return rs;
	}

}
