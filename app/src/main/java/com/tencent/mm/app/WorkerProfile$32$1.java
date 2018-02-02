package com.tencent.mm.app;

import com.tencent.mm.app.WorkerProfile.32;
import com.tencent.mm.modelmulti.a;
import com.tencent.mm.plugin.bbom.q;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WorkerProfile$32$1 implements Runnable {
    final /* synthetic */ bx fgR;
    final /* synthetic */ 32 fgS;

    WorkerProfile$32$1(32 32, bx bxVar) {
        this.fgS = 32;
        this.fgR = bxVar;
    }

    public final void run() {
        if (ar.Hj()) {
            x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent processAddMsgDigestList");
            new a().a(this.fgR, new q(true));
        }
    }
}
