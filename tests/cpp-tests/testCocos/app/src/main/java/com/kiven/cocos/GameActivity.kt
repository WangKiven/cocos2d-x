package com.kiven.cocos

import android.os.Bundle
import org.cocos2dx.lib.Cocos2dxActivity

class GameActivity : Cocos2dxActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.setEnableVirtualButton(false)
        super.onCreate(savedInstanceState)
        // Workaround in https://stackoverflow.com/questions/16283079/re-launch-of-activity-on-home-button-but-only-the-first-time/16447508
        // Workaround in https://stackoverflow.com/questions/16283079/re-launch-of-activity-on-home-button-but-only-the-first-time/16447508
        if (!isTaskRoot) {
            // Android launched another instance of the root activity into an existing task
            //  so just quietly finish and go away, dropping the user back into the activity
            //  at the top of the stack (ie: the last state of this task)
            // Don't need to finish it again since it's finished in super.onCreate .
            return
        }
        // DO OTHER INITIALIZATION BELOW
    }
}