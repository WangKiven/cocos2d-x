package com.kiven.cocos

import android.app.Activity
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

object CHelper {
//    external fun getGLContextAttrs(): IntArray


    fun onLoadNativeLibraries(context: Context) {
        try {
            val ai: ApplicationInfo = context.packageManager.getApplicationInfo(
                context.packageName,
                PackageManager.GET_META_DATA
            )
            val bundle = ai.metaData
            val libName = bundle.getString("android.app.lib_name")
            System.loadLibrary(libName)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}