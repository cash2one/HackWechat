package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.g.a.ky;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class q$11 extends c<ky> {
    final /* synthetic */ q yLH;

    q$11(q qVar) {
        this.yLH = qVar;
        this.xen = ky.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (q.c(this.yLH) != null) {
            q.c(this.yLH).getContext().runOnUiThread(new 1(this));
        }
        return true;
    }
}
