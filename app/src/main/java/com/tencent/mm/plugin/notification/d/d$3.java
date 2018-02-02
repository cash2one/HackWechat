package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.nq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class d$3 implements Runnable {
    final /* synthetic */ long fhh;
    final /* synthetic */ au heR;
    final /* synthetic */ d oUs;

    d$3(d dVar, long j, au auVar) {
        this.oUs = dVar;
        this.fhh = j;
        this.heR = auVar;
    }

    public final void run() {
        x.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", new Object[]{Long.valueOf(this.fhh)});
        b nqVar = new nq();
        nqVar.fFG.fnB = this.heR;
        a.xef.m(nqVar);
    }
}
