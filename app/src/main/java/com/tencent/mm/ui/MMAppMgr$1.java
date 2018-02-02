package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;

class MMAppMgr$1 implements a {
    final /* synthetic */ MMAppMgr xJS;

    MMAppMgr$1(MMAppMgr mMAppMgr) {
        this.xJS = mMAppMgr;
    }

    public final boolean uF() {
        String by = bh.by(ac.getContext());
        if (by == null || !by.toLowerCase().startsWith(ac.getPackageName())) {
            x.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ac.getContext().sendBroadcast(intent);
        } else {
            x.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
        }
        return false;
    }
}
