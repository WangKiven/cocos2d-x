package com.kiven.cocos

import android.os.Bundle
import com.kiven.kutils.activityHelper.KActivityHelper
import com.kiven.kutils.activityHelper.KHelperActivity
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
        Cocos2dxHelper.init(activity)

        setContentView(surfaceView)
    }

    override fun showDialog(pTitle: String?, pMessage: String?) {

    }

    override fun runOnGLThread(pRunnable: Runnable?) {
        surfaceView.queueEvent(pRunnable)
    }
}