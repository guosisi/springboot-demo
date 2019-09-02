package com.hshbic.ai.common.utils.mail;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
/**
 * 邮件发送工具类
 * 
 * @Description:
 * @project mailUtil
 */

public class MailUtil {

	/**
	 * 根据模板名称查找模板，加载模板内容后发送邮件
	 *
	 * @param receiver
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param map
	 *            邮件内容与模板内容转换对象
	 * @param templateName
	 *            模板文件名称
	 * @throws IOException
	 * @throws TemplateException
	 * @throws MessagingException
	 * @Description:
	 * @return void
	 */
	public static void sendMailByTemplate(String receiver, String subject,
			Map<String, String> map, String templateName,String subReceiver) throws IOException,
			TemplateException, MessagingException {
		String maiBody = "";
		String server = MailConfig.server;
		String sender = MailConfig.sender;
		String username = MailConfig.username;
		String password = MailConfig.password;
		String nickname = MailConfig.nickname;
		Boolean auth = MailConfig.auth;
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(auth);
		mail.setNamePass(username, password, nickname);
		maiBody = TemplateFactory.generateHtmlFromFtl(templateName, map);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.setCopyTo(subReceiver);
		mail.sendout();
	}

	/**
	 * 根据模板名称查找模板，加载模板内容后发送邮件(附件发送)
	 *
	 * @param receiver
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param map
	 *            邮件内容与模板内容转换对象
	 * @param templateName
	 *            模板文件名称
	 * @throws IOException
	 * @throws TemplateException
	 * @throws MessagingException
	 * @Description:
	 * @return void
	 */
	public static void sendMailAndFileByTemplate(String receiver,
			String subject, String filePath, Map<String, String> map,
			String templateName,String subReceiver) throws IOException, TemplateException,
            MessagingException {
		String maiBody = "";
		String server = MailConfig.server;
		String sender = MailConfig.sender;
		String username = MailConfig.username;
		String password = MailConfig.password;
		String nickname = MailConfig.nickname;
		Boolean auth = MailConfig.auth;
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		maiBody = TemplateFactory.generateHtmlFromFtl(templateName, map);
		mail.setSubject(subject);
		mail.addFileAffix(filePath);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		if(!StringUtils.isEmpty(subReceiver)){
			mail.setCopyTo(subReceiver);
		}
		mail.sendout();
	}

	/**
	 * 普通方式发送邮件内容
	 *
	 * @param receiver
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param maiBody
	 *            邮件正文
	 * @throws IOException
	 * @throws MessagingException
	 * @Description:
	 * @return void
	 */
	public static void sendMail(String receiver, String subject, String maiBody)
			throws IOException, MessagingException {
		String server = MailConfig.server;
		String sender = MailConfig.sender;
		String username = MailConfig.username;
		String password = MailConfig.password;
		String nickname = MailConfig.nickname;
		Boolean auth = MailConfig.auth;
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

	/**
	 * 普通方式发送邮件内容，并且附带文件附件
	 *
	 * @param receiver
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param filePath
	 *            文件的绝对路径
	 * @param maiBody
	 *            邮件正文
	 * 
	 * @throws IOException
	 * @throws MessagingException
	 * @Description:
	 * @return void
	 */
	public static void sendMailAndFile(String receiver, String subject,
			String filePath, String maiBody) throws IOException,
            MessagingException {
		String server = MailConfig.server;
		String sender = MailConfig.sender;
		String username = MailConfig.username;
		String password = MailConfig.password;
		String nickname = MailConfig.nickname;
		Boolean auth = MailConfig.auth;
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.addFileAffix(filePath);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

}
