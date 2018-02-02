package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c hQj;

    c$1(c cVar) {
        this.hQj = cVar;
    }

    public final boolean uF() {
        x.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[]{Boolean.valueOf(m.eJ(ac.getContext())), Boolean.valueOf(!bh.ov(c.bz(ac.getContext()))), c.bz(ac.getContext())});
        if (m.eJ(ac.getContext()) && r0) {
            return true;
        }
        c.b(this.hQj).post(new 1(this));
        return false;
    }
}
