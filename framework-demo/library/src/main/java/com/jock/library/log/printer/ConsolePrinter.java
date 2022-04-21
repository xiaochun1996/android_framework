package com.jock.library.log.printer;

import android.util.Log;

import com.jock.library.log.LogConfig;

import androidx.annotation.NonNull;

import static com.jock.library.log.LogConfig.MAX_LEN;

/**
 * @description: 控制台打印
 * @author: lxc
 * @date: 2022/4/14 22:47
 */
public class ConsolePrinter implements LogPrinter {
	
	@Override
	public void print(@NonNull LogConfig config, int level, String tag,
					  @NonNull String printString) {
		int len = printString.length();
		int countOfSub = len/ MAX_LEN;
		if(countOfSub>0){
			StringBuilder log = new StringBuilder();
			int index = 0;
			for(int i=0;i<countOfSub;i++){
				log.append(printString.substring(index, index + MAX_LEN));
				index+=MAX_LEN;
			}
			if(index != len ){
				log.append(printString.substring(index, len));
			}
			Log.println(level, tag, log.toString());
		} else {
			Log.println(level, tag, printString);
		}
	}
}
