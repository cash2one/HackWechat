package com.tencent.mm.ui;

import com.tencent.mm.g.a.to;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class h$3 extends c<to> {
    final /* synthetic */ h xFs;

    h$3(h hVar) {
        this.xFs = hVar;
        this.xen = to.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.xFs.getContentView().post(new 1(this));
        return false;
    }
}
