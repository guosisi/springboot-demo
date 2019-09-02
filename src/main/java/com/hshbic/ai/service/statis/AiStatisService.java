package com.hshbic.ai.service.statis;


import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;

public interface AiStatisService {

    public void statisActive() throws TemplateException, IOException, MessagingException;

}
