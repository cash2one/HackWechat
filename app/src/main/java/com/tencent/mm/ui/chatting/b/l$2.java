package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.my;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class l$2 extends c<my> {
    final /* synthetic */ l yzY;

    l$2(l lVar) {
        this.yzY = lVar;
        this.xen = my.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(this.yzY.fhr.css() == null || this.yzY.fhr.csB() == null)) {
            this.yzY.fhr.css().post(new 1(this));
        }
        return false;
    }
}
