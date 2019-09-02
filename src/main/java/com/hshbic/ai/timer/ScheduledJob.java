package com.hshbic.ai.timer;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.hshbic.ai.common.utils.DateUtil;
import com.hshbic.ai.service.statis.AiStatisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 */


@Configuration          //证明这个类是一个配置文件
@EnableScheduling       //打开quartz定时器总开关
public class ScheduledJob {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);
	
	@Autowired
	private AiStatisService aiStatisService;

	/**
	 * 每天早晨6:10发送最近的活跃用户统计
	 * */
//	@Scheduled(cron="0 10 6 * * ?")
//	@Scheduled(cron="0 */9 * * * ?")
	public void synFridgeDeviceToAi(){
		logger.info("*****timer start*******每天早晨6:10发送最近的活跃用户统计");
		try{
			aiStatisService.statisActive();
		}catch(Exception e){
			logger.error("每天早晨8:00发送最近的活跃用户统计时出错：",e);
		}
		logger.info("*****timer end*******每天早晨6:10发送最近的活跃用户统计，日期：{}" + DateUtil.currentDateFormat("yyyy-MM-dd"));
	}
	

	
}
