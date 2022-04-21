package com.jock.library.log;

import com.jock.library.log.formatter.StackTraceFormatter;
import com.jock.library.log.formatter.ThreadFormatter;
import com.jock.library.log.printer.LogPrinter;

/**
 * Description: 日志配置
 * Date: 2022/4/14 14:18
 *
 * @author lxc
 */
public class LogConfig {
	
	public static int MAX_LEN = 512;
	public static ThreadFormatter THREAD_FORMAT = new ThreadFormatter();
	public static StackTraceFormatter STACK_TRACE_FORMAT = new StackTraceFormatter();
	
	public JsonParser injectJsonParser() {
		return null;
	}
	
	public int setStackTraceDepth() {
		return 5;
	}
	
	public String getGlobalTag() {
		return "logger";
	}
	
	public boolean enable() {
		return true;
	}
	
	public boolean includeThread() {
		return true;
	}
	
	public LogPrinter[] printers() {
		return null;
	}
	
	public interface JsonParser {
		
		/**
		 * 对象转 json
		 * @param src 源对象
		 * @return String 字符串
		 */
		String toJson(Object src);
	}
}
