package com.jock.library.log;


import com.jock.library.log.printer.LogPrinter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * Description: 日志管理器
 *
 * @author lxc
 * @date: 2022/4/14 14:18
 */
public class LogManager {
	
	private final LogConfig config;
	private static LogManager instance;
	
	private final List<LogPrinter> printers = new ArrayList<>();
	
	private LogManager(LogConfig config) {
		this.config = config;
	}
	
	public static LogManager getInstance() {
		return instance;
	}
	
	public static LogManager init(@NonNull LogConfig config) {
		return instance = new LogManager(config);
	}
	
	public LogConfig getConfig() {
		return config;
	}
	
	public List<LogPrinter> getPrinters() {
		return printers;
	}
	
	public void addPrinter(LogPrinter printer) {
		printers.add(printer);
	}
	
	public void removePrinter(LogPrinter printer) {
		printers.remove(printer);
	}
}
