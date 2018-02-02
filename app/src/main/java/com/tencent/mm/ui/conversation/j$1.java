package com.tencent.mm.ui.conversation;

import com.tencent.mm.ui.conversation.g.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$1 implements b {
    final /* synthetic */ j yZL;

    j$1(j jVar) {
        this.yZL = jVar;
    }

    public final void cwC() {
        j.a(this.yZL).clearCache();
        ar.Hg();
        c.Fd().a(j.a(this.yZL));
        ar.Hg();
        c.EY().a(j.a(this.yZL));
    }
}
