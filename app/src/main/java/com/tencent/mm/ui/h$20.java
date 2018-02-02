package com.tencent.mm.ui;

import com.tencent.mm.g.a.pb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class h$20 extends c<pb> {
    final /* synthetic */ h xFs;

    h$20(h hVar) {
        this.xFs = hVar;
        this.xen = pb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((pb) bVar) instanceof pb) {
            h.g(this.xFs);
            h.a(this.xFs).notifyDataSetChanged();
        }
        return false;
    }
}
