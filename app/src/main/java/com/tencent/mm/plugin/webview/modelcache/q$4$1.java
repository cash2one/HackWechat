package com.tencent.mm.plugin.webview.modelcache;

import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.webview.modelcache.q.4;

class q$4$1 implements IdleHandler {
    final /* synthetic */ 4 tuc;

    q$4$1(4 4) {
        this.tuc = 4;
    }

    public final boolean queueIdle() {
        if (VERSION.SDK_INT >= 18) {
            this.tuc.tub.oAt.getLooper().quitSafely();
        } else {
            this.tuc.tub.oAt.getLooper().quit();
        }
        return false;
    }
}
