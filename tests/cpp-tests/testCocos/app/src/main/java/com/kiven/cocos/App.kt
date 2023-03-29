package com.kiven.cocos

import com.kiven.kutils.tools.KContext

class App: KContext() {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}