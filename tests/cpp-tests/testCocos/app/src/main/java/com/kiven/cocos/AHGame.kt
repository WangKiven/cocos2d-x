package com.kiven.cocos

import android.os.Bundle
import com.kiven.kutils.activityHelper.KActivityHelper
import com.kiven.kutils.activityHelper.KHelperActivity
import com.kiven.kutils.tools.KUtil
import org.cocos2dx.lib.Cocos2dxGLSurfaceView
import org.cocos2dx.lib.Cocos2dxHelper
import org.cocos2dx.lib.Cocos2dxRenderer

open class AHGame : KActivityHelper(), Cocos2dxHelper.Cocos2dxHelperListener {
    private val surfaceView by lazy { Cocos2dxGLSurfaceView(mActivity).apply { setCocos2dxRenderer(Cocos2dxRenderer()) } }

    override fun onCreate(activity: KHelperActivity, savedInstanceState: Bundle?) {
        super.onCreate(activity, savedInstanceState)
//        if (!activity.isTaskRoot) {
//            finish()
//            return
//        }
        activity.supportActionBar?.hide()

        // 加载so库
        CHelper.onLoadNativeLibraries(activity)

        Cocos2dxHelper.sCocos2dxHelperListener = this
        Cocos2dxHelper.init(activity.baseContext)

        setContentView(surfaceView)
    }

    override fun showDialog(pTitle: String?, pMessage: String?) {
//KUtil.getScreenDensityDpi()
    }

    override fun runOnGLThread(pRunnable: Runnable?) {
        surfaceView.queueEvent(pRunnable)
    }
}