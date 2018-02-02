package com.tencent.mm.ui.conversation;

import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class d$2 implements Runnable {
    final /* synthetic */ d yWX;

    d$2(d dVar) {
        this.yWX = dVar;
    }

    public final void run() {
        if (ar.Hj()) {
            long Wp = t.Wp();
            d.g(this.yWX);
            x.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[]{Long.valueOf(t.bz(Wp) * 3), Long.valueOf(d.cws()), Boolean.valueOf(d.d(this.yWX))});
            d.gp((Wp + d.cws()) / 2);
            d.h(this.yWX);
            ak f = d.f(this.yWX);
            long cws = d.cws();
            f.J(cws, cws);
            return;
        }
        d.f(this.yWX).TG();
        x.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
    }
}
