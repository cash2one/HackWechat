package com.tencent.mm.modelmulti;

import com.tencent.mm.g.a.jx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ak.b.a;

class a$1 implements a {
    final /* synthetic */ q gIw;
    final /* synthetic */ a hEA;
    final /* synthetic */ String hEz;

    a$1(a aVar, q qVar, String str) {
        this.hEA = aVar;
        this.gIw = qVar;
        this.hEz = str;
    }

    public final void v(String str, boolean z) {
        if (this.gIw != null && this.gIw.chR()) {
            b jxVar = new jx();
            jxVar.fAY.chatroomName = this.hEz;
            jxVar.fAY.fAZ = this.gIw.chQ();
            com.tencent.mm.sdk.b.a.xef.m(jxVar);
        }
    }
}
