package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.protocal.c.bvi;

class p$8 implements Runnable {
    final /* synthetic */ p iRt;
    final /* synthetic */ int iRu;
    final /* synthetic */ bvi iRv;

    p$8(p pVar, int i, bvi com_tencent_mm_protocal_c_bvi) {
        this.iRt = pVar;
        this.iRu = i;
        this.iRv = com_tencent_mm_protocal_c_bvi;
    }

    public final void run() {
        p.a(this.iRt, "cmdId " + this.iRu + ", errCode " + this.iRv.fts);
    }
}
