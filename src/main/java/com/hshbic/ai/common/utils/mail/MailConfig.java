package com.hshbic.ai.common.utils.mail;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
//@Data
public class MailConfig {
	//日志记录对象
	private static Logger log = LoggerFactory.getLogger(MailConfig.class);

	// 邮件发送SMTP主机
//	@Value("${mail.server}")
	public static String server = "smtp.163.com" ;
	// 发件人邮箱地址
//	@Value("${mail.sender}")
	public  static String sender ="uhomeBj@163.com";
	// 发件人邮箱用户名
//	@Value("${mail.username}")
	public static  String username ="uhomeBj@163.com";
	// 发件人邮箱密码
//	@Value("${mail.password}")
	public static String password ="uhomeBj@163.com";
	// 发件人显示昵称
//	@Value("${mail.nickname}")
	public  static String nickname ="\\u6d77\\u5c14\\u4f18\\u5bb6\\u7cfb\\u7edf\\u90ae\\u4ef6\\uff08\\u8bf7\\u52ff\\u56de\\u590d\\uff09";
	//设置是否进行密码登录
//	@Value("${mail.auth}")
	public static  Boolean auth = true;

	/*@Value("${mail.server}")
	public static void setServer(String server) {
		server = server;
	}
	@Value("${mail.sender}")
	public static void setSender(String sender) {
		sender = sender;
	}
	@Value("${mail.username}")
	public static void setUsername(String username) {
		username = username;
	}
	@Value("${mail.password}")
	public static void setPassword(String password) {
		password = password;
	}
	@Value("${mail.nickname}")
	public static void setNickname(String nickname) {
		nickname = nickname;
	}
	@Value("${mail.auth}")
	public static void setAuth(Boolean auth) {
		auth = auth;
	}*/
}

