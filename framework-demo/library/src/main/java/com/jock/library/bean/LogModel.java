package com.jock.library.bean;


import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @description: 日志 JavaBean
 * @author: lxc
 * @date: 2022/4/15 13:57
 */
public class LogModel {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
	public long timeMillis;
	public int level;
	public String tag;
	public String log;
	
	public LogModel(long timeMillis, int level, String tag, String log) {
		this.timeMillis = timeMillis;
		this.level = level;
		this.tag = tag;
		this.log = log;
	}
	
	public String flattenedLog() {
		return getFlattened() + "\n" + log;
	}
	
	public String getFlattened() {
		return format(timeMillis) + '|' + level + '|' + tag + "|:";
	}
	
	private String format(long timeMillis) {
		return sdf.format(timeMillis);
	}
}
