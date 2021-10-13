package com.screen.compatibility

import android.app.Activity
import android.content.Context
import java.lang.IllegalArgumentException

/**
 * Created by zzz on 2021/10/13
 */
object DensityHandler {

    private var defaultDensity = 0f
    private var defaultScaleDensity = 0f
    private var defaultDensityDpi = 0

    /**
     * 修改屏幕参数
     */
    fun setScreenDip(activity: Activity, width: Int) {
        if (width <= 0) {
            throw IllegalArgumentException("with must be > 0")
        }
        val appMetrics = activity.applicationContext.resources.displayMetrics
        if (defaultScaleDensity == 0f) {
            // 获取初始化数据,修改dp之后，原有字体的大小比例不会，density 和 scaleDensity 应保持原有比例
            defaultDensity = appMetrics.density
            defaultScaleDensity = appMetrics.scaledDensity
            defaultDensityDpi = appMetrics.densityDpi
        }

        // density = px / dp
        val targetDensity = appMetrics.widthPixels / width.toFloat()
        // density =  dpi / 160
        val targetDensityDpi = (targetDensity * 160).toInt()
        // 求字体缩放比例
        // 系统设置修改字体大小，即是修改此值，默认情况下 1dp = 1sp
        val targetScaleDensity = targetDensity * (defaultScaleDensity / defaultDensity)

        //替换参数
        appMetrics.density = targetDensity
        appMetrics.scaledDensity = targetScaleDensity
        appMetrics.densityDpi = targetDensityDpi

        val activityMetrics = activity.resources.displayMetrics
        activityMetrics.density = targetDensity
        activityMetrics.densityDpi = targetDensityDpi
        activityMetrics.scaledDensity = targetScaleDensity
    }

    /**
     * 恢复屏幕参数
     */
    fun reset(activity: Activity) {
        //替换参数
        val appMetrics = activity.applicationContext.resources.displayMetrics
        appMetrics.density = defaultDensity
        appMetrics.densityDpi = defaultDensityDpi
        appMetrics.scaledDensity = defaultScaleDensity

        val activityMetrics = activity.resources.displayMetrics
        activityMetrics.density = defaultDensity
        activityMetrics.densityDpi = defaultDensityDpi
        activityMetrics.scaledDensity = defaultScaleDensity
    }
}