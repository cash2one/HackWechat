package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class o$10 implements a {
    final /* synthetic */ o ysq;

    o$10(o oVar) {
        this.ysq = oVar;
    }

    public final boolean uF() {
        long vy = o.a(this.ysq).vy();
        x.d("MicroMsg.ChattingFooterEventImpl", "ms " + vy);
        if (vy >= 50000 && vy <= 60000) {
            if (!o.m(this.ysq)) {
                bh.eW(o.f(this.ysq).getContext());
                o.a(this.ysq, true);
            }
            int i = (int) ((60000 - vy) / 1000);
            o.d(this.ysq).Sz(o.f(this.ysq).thisResources().getQuantityString(R.j.duo, i, new Object[]{Integer.valueOf(i)}));
        }
        if (vy < 60000) {
            return true;
        }
        x.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
        o.n(this.ysq);
        o.d(this.ysq).aJO();
        ar.H(o.f(this.ysq).getContext(), R.l.eRg);
        return false;
    }
}
