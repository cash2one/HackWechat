package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.plugin.freewifi.ui.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$2$1 implements Runnable {
    final /* synthetic */ View mGF;
    final /* synthetic */ 2 mGG;

    a$2$1(2 2, View view) {
        this.mGG = 2;
        this.mGF = view;
    }

    public final void run() {
        b bgVar = new bg();
        long currentTimeMillis = System.currentTimeMillis();
        a.xef.m(bgVar);
        x.i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ag.y(new 1(this, bgVar));
    }
}
