package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.g.a.bd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

class b$2 implements Runnable {
    final /* synthetic */ int vgr;
    final /* synthetic */ int vgs;
    final /* synthetic */ b vgv;
    final /* synthetic */ int vgw;
    final /* synthetic */ boolean vgx;

    b$2(b bVar, int i, int i2, int i3, boolean z) {
        this.vgv = bVar;
        this.vgw = i;
        this.vgr = i2;
        this.vgs = i3;
        this.vgx = z;
    }

    public final void run() {
        b bdVar = new bd();
        bdVar.fpq.fpr = this.vgw;
        bdVar.fpq.fpm = this.vgr;
        bdVar.fpq.fpn = this.vgs;
        bdVar.fpq.fpt = this.vgx;
        a.xef.m(bdVar);
    }
}
