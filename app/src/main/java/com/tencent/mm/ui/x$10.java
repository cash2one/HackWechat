package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class x$10 implements Runnable {
    final /* synthetic */ x xKV;

    x$10(x xVar) {
        this.xKV = xVar;
    }

    public final void run() {
        if (this.xKV.xKQ) {
            x.i("MicroMsg.LauncherUI.MainTabUnreadMgr", "remove setTagRunnable");
            ag.K(this.xKV.xKR);
        }
    }
}
