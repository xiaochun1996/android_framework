package com.jock.library.log.formatter;

/**
 * @description: 堆栈信息打印
 * @author: lxc
 * @date: 2022/4/14 22:31
 */
public class ThreadFormatter implements LogFormatter<Thread> {
	
	@Override
	public String format(Thread thread) {
		return "Thread:" + thread.getName();
	}
}
