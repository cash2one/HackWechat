package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.sdk.b.a;

class h$8 implements i {
    final /* synthetic */ gs nxd;
    final /* synthetic */ h xFs;

    h$8(h hVar, gs gsVar) {
        this.xFs = hVar;
        this.nxd = gsVar;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        this.nxd.fwO.pK = 2;
        this.nxd.fwO.url = str;
        a.xef.m(this.nxd);
    }
}
