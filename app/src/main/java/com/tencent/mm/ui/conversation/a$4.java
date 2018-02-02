package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.jf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$4 extends c<jf> {
    final /* synthetic */ a yVT;

    a$4(a aVar) {
        this.yVT = aVar;
        this.xen = jf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (this.yVT.yVR.getVisibility() != 0) {
            this.yVT.yVR.setVisibility(0);
            this.yVT.yVS.setVisibility(8);
        }
        return false;
    }
}
