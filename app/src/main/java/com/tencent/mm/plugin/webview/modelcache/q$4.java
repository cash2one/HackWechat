package com.tencent.mm.plugin.webview.modelcache;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class q$4 implements Runnable {
    final /* synthetic */ q ttX;
    final /* synthetic */ ag tub;

    q$4(q qVar, ag agVar) {
        this.ttX = qVar;
        this.tub = agVar;
    }

    public final void run() {
        Looper.myQueue().addIdleHandler(new 1(this));
    }
}
