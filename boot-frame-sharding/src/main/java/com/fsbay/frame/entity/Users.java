package com.fsbay.frame.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author TT
 * @since 2018-10-23
 */
@Data
@TableName("Users")
public class Users {
    /**
     * user编号（关联查询）
     */
    @TableId(value = "guid", type = IdType.UUID)
    private String guid;
    /**
     * 创建
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 存档
标识
     */
    @TableField("archived")
    private Integer archived;
    /**
     * 版本
     */
    @TableField("version")
    private Integer version;
    /**
     * 游戏密码
     */
    @TableField("password")
    private String password;
    /**
     * 游戏账号
     */
    @TableField("username")
    private String username;
    /**
     * 无用字段
     */
    @TableField("default_user")
    private Integer defaultUser;
    /**
     * 头像url
     */
    @TableField("avator_url")
    private String avatorUrl;
    /**
     * 用户类型（qq，annoy：匿名，weixin，ordinary：正常，phone）
     */
    @TableField("user_type")
    private String userType;
    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;
    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;
    /**
     * 用户描述

     */
    @TableField("description")
    private String description;
    /**
     * 图片合成次数
     */
    @TableField("image_count")
    private Long imageCount;
    /**
     * 模板训练次数
     */
    @TableField("template_count")
    private Long templateCount;
    /**
     * 邮件
     */
    @TableField("mail")
    private String mail;
    /**
     * 关联表ice_gamekindinfo字段client_id
     */
    @TableField("client_id")
    private String clientId;
    /**
     * 渠道
     */
    @TableField("channel")
    private String channel;
    /**
     * open_id
     */
    @TableField("open_id")
    private String openId;
    /**
     * 设备号
     */
    @TableField("device_id")
    private String deviceId;
    /**
     * 最近登陆时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 是否测试
     */
    @TableField("istest")
    private Integer istest;


}
