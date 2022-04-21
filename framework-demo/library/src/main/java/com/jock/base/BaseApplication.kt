package com.jock.base

import android.app.Application
import com.google.gson.Gson
import com.jock.library.log.LogConfig
import com.jock.library.log.LogManager
import com.jock.library.log.printer.ConsolePrinter

/**
 * Description:框架初始化
 * Author: lxc
 * Date: 2022/4/14 15:36
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = object :LogConfig(){
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }
        }
        val manager = LogManager.init(config)
        val printer = ConsolePrinter()
        manager.addPrinter(printer)
    }
}