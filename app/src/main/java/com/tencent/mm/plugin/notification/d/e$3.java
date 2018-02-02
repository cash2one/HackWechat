package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.ns;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class e$3 implements Runnable {
    final /* synthetic */ long fhh;
    final /* synthetic */ e oUz;

    e$3(e eVar, long j) {
        this.oUz = eVar;
        this.fhh = j;
    }

    public final void run() {
        x.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", new Object[]{Long.valueOf(this.fhh)});
        b nsVar = new ns();
        nsVar.fFK.fFL = (int) this.fhh;
        a.xef.m(nsVar);
    }
}
