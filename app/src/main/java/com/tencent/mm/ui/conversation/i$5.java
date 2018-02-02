package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.rr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class i$5 extends c<rr> {
    final /* synthetic */ i yZy;

    i$5(i iVar) {
        this.yZy = iVar;
        this.xen = rr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (i.a(this.yZy) == null) {
            x.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
        } else {
            i.b(this.yZy);
            i.c(this.yZy);
        }
        return false;
    }
}
