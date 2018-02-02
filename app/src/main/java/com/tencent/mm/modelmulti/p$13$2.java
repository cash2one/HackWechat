package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.13;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba.1;
import java.util.List;

class p$13$2 implements Runnable {
    final /* synthetic */ 13 hHa;
    final /* synthetic */ c hHb;

    p$13$2(13 13, c cVar) {
        this.hHa = 13;
        this.hHb = cVar;
    }

    public final void run() {
        int i;
        p.a(this.hHa.hGP, null);
        List aZk = ((h) g.h(h.class)).FJ().aZk();
        if (bh.cA(aZk)) {
            x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
            i = 0;
        } else {
            e.post(new 1(aZk), "checkUnfinishedDeleteMsgTask");
            i = aZk.size();
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(418, 8, 1, true);
        }
        p.a(this.hHa.hGP, p.a(this.hHa.hGP, this.hHb));
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", new Object[]{p.o(this.hHa.hGP)});
    }
}
