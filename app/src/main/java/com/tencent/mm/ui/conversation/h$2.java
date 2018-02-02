package com.tencent.mm.ui.conversation;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class h$2 implements Runnable {
    final /* synthetic */ h yYV;

    h$2(h hVar) {
        this.yYV = hVar;
    }

    public final void run() {
        if (ar.Hj()) {
            long Wp = t.Wp();
            h.d(this.yYV);
            x.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[]{Long.valueOf(t.bz(Wp) * 3), Long.valueOf(h.cwE()), Boolean.valueOf(h.a(this.yYV))});
            h.gq((Wp + h.cwE()) / 2);
            h.e(this.yYV);
            ak c = h.c(this.yYV);
            long cwE = h.cwE();
            c.J(cwE, cwE);
            return;
        }
        h.c(this.yYV).TG();
        x.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
    }
}
