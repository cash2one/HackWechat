package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.g.a.lk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$1 extends c<lk> {
    final /* synthetic */ a krI;

    a$1(a aVar) {
        this.krI = aVar;
        this.xen = lk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.krI.getView().post(new 1(this));
        return false;
    }
}
