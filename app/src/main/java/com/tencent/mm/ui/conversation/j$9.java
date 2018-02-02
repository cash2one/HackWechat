package com.tencent.mm.ui.conversation;

import com.tencent.mm.ad.n;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$9 implements Runnable {
    final /* synthetic */ j yZL;

    j$9(j jVar) {
        this.yZL = jVar;
    }

    public final void run() {
        a c = j.c(this.yZL);
        n.Jz().d(c);
        ar.Hg();
        c.CU().a(c);
        c.cwo();
    }
}
