package com.jock.library.log.formatter;

/**
 * @description: 格式化接口
 * @author: lxc
 * @date: 2022/4/14 22:26
 */
interface LogFormatter<T> {
	
	/**
	 * 数据格式化
	 * @param data 源数据
	 * @return 格式化后的 String 字符串
	 */
	String format(T data);
}
