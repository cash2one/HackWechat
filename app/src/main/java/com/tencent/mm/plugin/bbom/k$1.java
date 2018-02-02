package com.tencent.mm.plugin.bbom;

import com.tencent.mm.g.a.jx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ak.b.a;

class k$1 implements a {
    final /* synthetic */ q gIw;
    final /* synthetic */ String heS;
    final /* synthetic */ k kvC;

    k$1(k kVar, q qVar, String str) {
        this.kvC = kVar;
        this.gIw = qVar;
        this.heS = str;
    }

    public final void v(String str, boolean z) {
        if (this.gIw != null && this.gIw.chR()) {
            b jxVar = new jx();
            jxVar.fAY.chatroomName = this.heS;
            jxVar.fAY.fAZ = this.gIw.chQ();
            com.tencent.mm.sdk.b.a.xef.m(jxVar);
        }
    }
}
