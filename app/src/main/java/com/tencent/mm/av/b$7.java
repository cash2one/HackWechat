package com.tencent.mm.av;

import com.tencent.mm.g.a.jr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.List;

class b$7 implements Runnable {
    final /* synthetic */ List hHT;
    final /* synthetic */ int hHU;

    public b$7(List list, int i) {
        this.hHT = list;
        this.hHU = i;
    }

    public final void run() {
        b jrVar = new jr();
        jrVar.fAt.action = 0;
        jrVar.fAt.fvF = this.hHT;
        jrVar.fAt.fAw = this.hHU;
        a.xef.m(jrVar);
    }
}
