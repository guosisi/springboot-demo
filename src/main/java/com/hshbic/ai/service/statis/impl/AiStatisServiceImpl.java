package com.hshbic.ai.service.statis.impl;


import com.hshbic.ai.common.utils.DateUtil;
import com.hshbic.ai.common.utils.mail.MailService;
import com.hshbic.ai.common.utils.mail.MailUtil;
import com.hshbic.ai.dao.statis.StatisNlpAllMapper;
import com.hshbic.ai.service.statis.AiStatisService;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;


@Service("aiStatisService")
public class AiStatisServiceImpl implements AiStatisService {

    private static final Logger logger = LoggerFactory.getLogger(AiStatisServiceImpl.class);

    private String activeTr = "<tr><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%d</td><td></td></tr>";

    @Value("${spring.mail.template.active}")
    private String activeTmpName;

    @Autowired
    MailService mailService;

    @Autowired(required = false)
    private StatisNlpAllMapper statisNlpAllMapper;

    /**
     *每天早晨8:00发送最近的活跃用户统计
     * @param
     */
    @Override
    public void statisActive() throws TemplateException, IOException, MessagingException {

        String yesterday = DateUtil.evalTime(new Date(),"yyyy-MM-dd","day",-1);
        String end = yesterday+ " 23:59:59";
        String yestodayStart = yesterday+ " 00:00:00";
        String weekSart = DateUtil.evalTime(new Date(),"yyyy-MM-dd","day",-7) + " 00:00:00";
        String monthSart = DateUtil.evalTime(new Date(),"yyyy-MM","month",0) + "-01 00:00:00";
        StringBuilder sb = new StringBuilder();

        Integer allYes = statisNlpAllMapper.selectUVByDate(yestodayStart, end);
        Integer allWeek = statisNlpAllMapper.selectUVByDate(weekSart, end);
        Integer allMonth = statisNlpAllMapper.selectUVByDate(monthSart, end);
        sb.append(String.format(activeTr,"部门1","收件人1",allYes, allMonth, allWeek)); // all

        String domain2= "Freezer,Fridge,IceBar,DrinksCabinet,vegetableManagement";
        List<String> domains2 = Arrays.asList(domain2.split(","));
        String appId2= "MB-SUAIVOICER-0000";
        List<String> appIds2 = Arrays.asList(appId2.split(","));
        Integer allYes2 = statisNlpAllMapper.selectUVByParams(yestodayStart, end, appIds2, domains2);
        Integer allWeek2 = statisNlpAllMapper.selectUVByParams(weekSart, end, appIds2, domains2);
        Integer allMonth2 = statisNlpAllMapper.selectUVByParams(monthSart, end, appIds2, domains2);
        sb.append(String.format(activeTr,"部门2","收件人2", allYes2, allMonth2, allWeek2)); // 制冷

        String domain3= "washingMacine,Dryer";
        List<String> domains3 = Arrays.asList(domain3.split(","));
        String appId3= "MB-SHAIERWASHER-0000,MB-SHBD14996ESU1-0000,MB-SBV12811U1-0000";
        List<String> appIds3 = Arrays.asList(appId3.split(","));
        Integer allYes3 = statisNlpAllMapper.selectUVByParams(yestodayStart, end, appIds3, domains3);
        Integer allWeek3 = statisNlpAllMapper.selectUVByParams(weekSart, end, appIds3, domains3);
        Integer allMonth3 = statisNlpAllMapper.selectUVByParams(monthSart, end, appIds3, domains3);
        sb.append(String.format(activeTr,"部门3","收件人3", allYes3, allMonth3, allWeek3)); // 洗护

        String domain4= "Fan,Dev.airCnditoner";
        List<String> domains4 = Arrays.asList(domain4.split(","));
        String appId4= "MB-STFT-0000";
        List<String> appIds4 = Arrays.asList(appId4.split(","));
        Integer allYes4 = statisNlpAllMapper.selectUVByParams(yestodayStart, end, appIds4, domains4);
        Integer allWeek4 = statisNlpAllMapper.selectUVByParams(weekSart, end, appIds4, domains4);
        Integer allMonth4 = statisNlpAllMapper.selectUVByParams(monthSart, end, appIds4, domains4);
        sb.append(String.format(activeTr,"部门4","收件人4", allYes4, allMonth4, allWeek4)); // 空气



        String domain5= "WaterPurier,Furnace";
        List<String> domains5 = Arrays.asList(domain5.split(","));
        Integer allYes5 = statisNlpAllMapper.selectUVByParam(yestodayStart, end, domains5);
        Integer allWeek5 = statisNlpAllMapper.selectUVByParam(weekSart, end, domains5);
        Integer allMonth5 = statisNlpAllMapper.selectUVByParam(monthSart, end, domains5);
        sb.append(String.format(activeTr,"部门5","收件人5", allYes5, allMonth5, allWeek5)); // 水圈


        String domain6= "WallBreaingMachie,Sterilzer";
        List<String> domains6 = Arrays.asList(domain6.split(","));
        Integer allYes6 = statisNlpAllMapper.selectUVByParam(yestodayStart, end, domains6);
        Integer allWeek6 = statisNlpAllMapper.selectUVByParam(weekSart, end, domains6);
        Integer allMonth6 = statisNlpAllMapper.selectUVByParam(monthSart, end, domains6);
        sb.append(String.format(activeTr,"部门6","收件人6", allYes6, allMonth6, allWeek6)); // 厨电


        String domain7= "DevTV";
        List<String> domains7 = Arrays.asList(domain7.split(","));
        String appId7= "MB-UAPPDS-0000";
        List<String> appIds7 = Arrays.asList(appId7.split(","));
        Integer allYes7 = statisNlpAllMapper.selectUVByParams(yestodayStart, end, appIds7, domains7);
        Integer allWeek7 = statisNlpAllMapper.selectUVByParams(weekSart, end, appIds7, domains7);
        Integer allMonth7 = statisNlpAllMapper.selectUVByParams(monthSart, end, appIds7, domains7);
        sb.append(String.format(activeTr,"部门7","收件人7", allYes7, allMonth7, allWeek7)); // 视听

        String domain8= "Dev.spaker";
        List<String> domains8 = Arrays.asList(domain8.split(","));
        String appId8= "MB-SMB-SHEZNTPYX-0001";
        List<String> appIds8 = Arrays.asList(appId8.split(","));
        Integer allYes8 = statisNlpAllMapper.selectUVByParams(yestodayStart, end, appIds8, domains8);
        Integer allWeek8 = statisNlpAllMapper.selectUVByParams(weekSart, end, appIds8, domains8);
        Integer allMonth8 = statisNlpAllMapper.selectUVByParams(monthSart, end, appIds8, domains8);
        sb.append(String.format(activeTr,"部门8","收件人8", allYes8, allMonth8, allWeek8)); // 互联





        String domain9 = "WindowCrtains";
       List<String> domains9 =Arrays.asList("Windowurtains".split(","));
        Integer allYes9 = statisNlpAllMapper.selectUVByParam(yestodayStart, end, domains9);
        Integer allWeek9 = statisNlpAllMapper.selectUVByParam(weekSart, end, domains9);
        Integer allMonth9 = statisNlpAllMapper.selectUVByParam(monthSart, end, domains9);
        sb.append(String.format(activeTr,"安防","武莹", allYes9, allMonth9, allWeek9)); // 安防

        // 发送邮件
        String [] receivers = {"guosidi@126.com"};
        String [] ccReceivers = {"guosidi@126.com", "guosidi@126.com"};
        Map<String, String> map = new HashMap<String, String>();

//        logger.info("==============>"+ sb.toString());
        map.put("tbody", sb.toString());
        map.put("date", yesterday);
        String subject = "数据统计"+yesterday;
        String templateName = activeTmpName;
        mailService.sendMessageMail(receivers, ccReceivers, map, subject, templateName);

    }
}
