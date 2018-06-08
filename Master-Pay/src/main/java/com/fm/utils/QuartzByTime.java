package com.fm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzByTime implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("--------运行开始---------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★★"); 
	}

}
