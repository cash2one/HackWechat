package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements Runnable {
    final /* synthetic */ WepkgCrossProcessTask tNf;
    final /* synthetic */ a tNo;
    final /* synthetic */ long tOh;

    d$2(long j, a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.tOh = j;
        this.tNo = aVar;
        this.tNf = wepkgCrossProcessTask;
    }

    public final void run() {
        x.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.tOh)});
        if (this.tNo != null) {
            this.tNo.a(this.tNf);
        }
        this.tNf.afj();
    }
}
