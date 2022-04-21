package com.jock.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jock.library.log.LogConfig
import com.jock.library.log.LogType
import com.jock.library.log.Logger
import com.jock.library.log.printer.LogPrinter
import com.jock.library.log.printer.ViewPrinter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val printer = ViewPrinter(this@MainActivity)
        printer.viewProvider.showFloatingView()

        val config = object:LogConfig(){
            override fun printers(): Array<LogPrinter> {
                return arrayOf(printer)
            }
        }

        findViewById<View>(R.id.tv_button).setOnClickListener {
            Logger.e("我是测试日志")
            Logger.at("opt","我是测试日志")
            Logger.wt("opt","我是测试日志")
            Logger.log(config, LogType.E,"custom","我是测试日志")
        }
    }
}