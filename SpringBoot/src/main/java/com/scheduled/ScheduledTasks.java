package com.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger Log = LoggerFactory.getLogger(ScheduledTasks.class);
		//定义一个时间
	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
	//fixedRate实现 表示从上一个任务开始到下一个任务开始的间隔，单位是毫秒
	@Scheduled(fixedRate=5000) //5000毫秒 也就是5秒
	public void reportCurrentTimeByfixedRate(){
		Log.info("飞燕你信么{}",dataFormat.format(new Date()));
	}
	//fixedDelay  表示从上一个任务完成到下一个任务开始的间隔，单位毫秒
	@Scheduled(fixedDelay=6000) //6000毫秒 也就是6秒
	public void reportCurrentTimeByfixedDelay(){
		Log.info("The time is now{}",dataFormat.format(new Date()));
	}
	
	//initialDelay 延迟  第一次延迟3秒执行
	@Scheduled(initialDelay=10000, fixedDelay=6000) //6000毫秒 也就是6秒
	public void reportCurrentTimeByDelay(){
		Log.info("The time is now2{}",dataFormat.format(new Date()));
	}
	
	//cron 
	//每天21点54分10秒时启动
	@Scheduled(cron="59 56 20 * * ?")
	public void timercron(){
		Log.info("The time is now{}",dataFormat.format(new Date()));
	}
}
