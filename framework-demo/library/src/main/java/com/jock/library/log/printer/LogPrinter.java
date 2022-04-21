package com.jock.library.log.printer;

import com.jock.library.log.LogConfig;
import com.jock.library.log.LogType;

import androidx.annotation.NonNull;

/**
 * @description: 打印器
 * @author: lxc
 * @date: 2022/4/14 22:26
 */
public interface LogPrinter {
	
	void print(@NonNull LogConfig config, @LogType.Type int level,String tag,@NonNull String printString);
}
