package com.tencent.mm.ui;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class h$17 extends c<ck> {
    final /* synthetic */ h xFs;

    h$17(h hVar) {
        this.xFs = hVar;
        super(1);
        this.xen = ck.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
        h.e(this.xFs).sendEmptyMessage(1);
        return true;
    }
}
