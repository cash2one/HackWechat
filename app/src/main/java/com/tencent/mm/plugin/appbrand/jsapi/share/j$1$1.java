package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.j.1;
import com.tencent.mm.sdk.platformtools.x;

class j$1$1 implements Runnable {
    final /* synthetic */ long jrl;
    final /* synthetic */ Bundle jrm;
    final /* synthetic */ 1 jrn;

    j$1$1(1 1, long j, Bundle bundle) {
        this.jrn = 1;
        this.jrl = j;
        this.jrm = bundle;
    }

    public final void run() {
        x.i("MicroMsg.ShareHelper", "notifyToRefreshImg(cost : %s)", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jrl)});
        this.jrm.putInt("action", 2);
        f.a("com.tencent.mm", this.jrm, a.class, null);
    }
}
