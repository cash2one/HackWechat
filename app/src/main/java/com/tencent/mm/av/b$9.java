package com.tencent.mm.av;

import com.tencent.mm.g.a.jr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.List;

class b$9 implements Runnable {
    final /* synthetic */ List hHV;
    final /* synthetic */ boolean hHW = true;

    public b$9(List list, boolean z) {
        this.hHV = list;
    }

    public final void run() {
        b jrVar = new jr();
        jrVar.fAt.action = 5;
        jrVar.fAt.fvF = this.hHV;
        jrVar.fAt.fAx = this.hHW;
        a.xef.m(jrVar);
    }
}
