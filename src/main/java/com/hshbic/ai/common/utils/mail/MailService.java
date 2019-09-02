package com.hshbic.ai.common.utils.mail;


import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service("mailService")
public class MailService {

    //邮件的发送者
    @Value("${spring.mail.username}")
    private String from;

    @Autowired(required = false)
    protected JavaMailSender javaMailSender;

    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;


     /**
     *发送 freemarker模板的邮件
     * @param receivers
     * @param params
     * @param subject
     * @param templateName
     */
    public void sendMessageMail(String[] receivers, Object params, String subject, String templateName) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(receivers);//发送给谁  //InternetAddress.parse(receivers)
            helper.setSubject(subject);//邮件标题

            Map<String, Object> model = new HashMap<>();
            model.put("params", params);
                Template template = configurer.getConfiguration().getTemplate(templateName);
                    String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                    helper.setText(text, true);
                    javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送 freemarker模板的邮件
     * @param receivers
     * @param ccReceivers
     * @param subject
     * @param templateName
     */
    public void sendMessageMail(String[] receivers, String[] ccReceivers, Object params, String subject, String templateName) {

        try {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(receivers);//发送给谁  //InternetAddress.parse(receivers)
            helper.setCc(ccReceivers);
            helper.setSubject(subject);//邮件标题

            Map<String, Object> model = new HashMap<>();
            model.put("params", params);

            Template template = configurer.getConfiguration().getTemplate(templateName);

            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(text, true);
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

