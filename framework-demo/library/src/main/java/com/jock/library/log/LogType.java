package com.jock.library.log;

import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * Description: 日志类型
 * Author: lxc
 * Date: 2022/4/14 13:19
 */
public class LogType {
	
	/**
	 * 日志类型
	 */
	public static final int V = Log.VERBOSE;
	public static final int D = Log.DEBUG;
	public static final int I = Log.INFO;
	public static final int W = Log.WARN;
	public static final int E = Log.ERROR;
	public static final int A = Log.ASSERT;
	
	@IntDef({V, D, I, W, E, A})
	@Retention(RetentionPolicy.SOURCE)
	public @interface Type{
	
	}
}
