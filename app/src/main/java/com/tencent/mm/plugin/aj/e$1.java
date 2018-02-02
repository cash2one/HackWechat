package com.tencent.mm.plugin.aj;

import android.os.Looper;
import com.tencent.mm.plugin.aj.e.7;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements Runnable {
    final /* synthetic */ e tjF;
    final /* synthetic */ String val$url;

    e$1(e eVar, String str) {
        this.tjF = eVar;
        this.val$url = str;
    }

    public final void run() {
        x.i(this.tjF.TAG, "preload start");
        Runnable 7 = new 7(this.tjF, this.val$url);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            7.run();
        } else {
            ag.y(7);
        }
    }
}
