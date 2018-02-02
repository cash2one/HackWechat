package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.chatting.p.b;

class p$b$2 implements a {
    final /* synthetic */ b ysO;

    p$b$2(b bVar) {
        this.ysO = bVar;
    }

    public final boolean uF() {
        if (!(b.d(this.ysO) == null || b.e(this.ysO) == null)) {
            b.e(this.ysO).showAsDropDown(b.d(this.ysO), b.f(this.ysO), b.g(this.ysO));
        }
        return false;
    }
}
