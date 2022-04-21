package com.jock.library.log;

import com.jock.library.util.StackTraceUtil;
import com.jock.library.log.printer.LogPrinter;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Description: 日志门面
 * Author: lxc
 * Date: 2022/4/14 14:16
 */
public class Logger {
	
	private static final String LOG_PACKAGE;
	
	static {
		String className = Logger.class.getName();
		LOG_PACKAGE = className.substring(0, className.lastIndexOf('.') + 1);
	}
	
	
	public static void v(Object... contents) {
		log(LogType.V, contents);
	}
	
	public static void vt(String tag, Object... contents) {
		log(LogType.V, tag, contents);
	}
	
	public static void d(Object... contents) {
		log(LogType.D, contents);
	}
	
	public static void dt(String tag, Object... contents) {
		log(LogType.D, tag, contents);
	}
	
	public static void i(Object... contents) {
		log(LogType.I, contents);
	}
	
	public static void it(String tag, Object... contents) {
		log(LogType.I, tag, contents);
	}
	
	public static void w(Object... contents) {
		log(LogType.W, contents);
	}
	
	public static void wt(String tag, Object... contents) {
		log(LogType.W, tag, contents);
	}
	
	public static void e(Object... contents) {
		log(LogType.E, contents);
	}
	
	public static void et(String tag, Object... contents) {
		log(LogType.E, tag, contents);
	}
	
	public static void a(Object... contents) {
		log(LogType.A, contents);
	}
	
	public static void at(String tag, Object... contents) {
		log(LogType.A, tag, contents);
	}
	
	public static void log(@LogType.Type int type, Object... contents) {
		log(type, LogManager.getInstance().getConfig().getGlobalTag(), contents);
	}
	
	public static void log(@LogType.Type int type, @NonNull String tag, Object... contents) {
		log(LogManager.getInstance().getConfig(), type, tag, contents);
	}
	
	public static void log(@NonNull LogConfig config, @LogType.Type int type, @NonNull String tag,
						   Object... contents) {
		if (!config.enable()) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (config.includeThread()) {
			String threadInfo = LogConfig.THREAD_FORMAT.format(Thread.currentThread());
			sb.append(threadInfo).append("\n");
		}
		if (config.setStackTraceDepth() > 0) {
			String stackTrace = LogConfig.STACK_TRACE_FORMAT.format(
					StackTraceUtil.getCroppedRealStackTrack(new Throwable().getStackTrace(),
							LOG_PACKAGE, config.setStackTraceDepth()));
			sb.append(stackTrace).append("\n");
		}
		String body = parseBody(contents, config);
		//替换转义字符
		if (body != null) {
			body = body.replace("\\\"", "\"");
		}
		sb.append("body:").append("\n");
		sb.append(body);
		List<LogPrinter> printers = config.printers() != null ? Arrays.asList(config.printers()) :
				LogManager.getInstance().getPrinters();
		if (printers == null) {
			return;
		}
		//打印log
		for (LogPrinter printer : printers) {
			printer.print(config, type, tag, sb.toString());
		}
	}
	
	private static String parseBody(@NonNull Object[] contents, @NonNull LogConfig config) {
		if (config.injectJsonParser() != null) {
			//只有一个数据且为String的情况下不再进行序列化
			if (contents.length == 1 && contents[0] instanceof String) {
				return (String) contents[0];
			}
			return config.injectJsonParser().toJson(contents);
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : contents) {
			sb.append(o.toString()).append(";");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
