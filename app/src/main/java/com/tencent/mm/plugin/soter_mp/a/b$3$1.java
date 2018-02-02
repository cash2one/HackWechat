package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.a.c.i;
import com.tencent.d.b.a.a;
import com.tencent.mm.plugin.soter_mp.a.b.3;

class b$3$1 implements Runnable {
    final /* synthetic */ a rTg;
    final /* synthetic */ 3 rTh;

    b$3$1(3 3, a aVar) {
        this.rTh = 3;
        this.rTg = aVar;
    }

    public final void run() {
        i iVar = (i) this.rTg.AcB;
        this.rTh.rTf.rTk.errCode = 0;
        this.rTh.rTf.rTk.fnL = "OK";
        this.rTh.rTf.rTk.rTn = (byte) 1;
        this.rTh.rTf.rTk.fGm = iVar.AcA;
        this.rTh.rTf.rTk.rTo = iVar.signature;
        this.rTh.rTf.bCY();
    }
}
