package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.h;
import com.tencent.mm.protocal.c.ayl;

public final class e extends a implements h.a {
    private h nGz = null;

    public final int[] aTJ() {
        return new int[0];
    }

    public final int LC() {
        return 8;
    }

    public final void aTK() {
        this.nGz = new h();
        this.nGz.nCU = this;
        com.tencent.mm.sdk.b.a.xef.b(this.nGz);
    }

    public final void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.nGz);
    }

    public final void b(c cVar) {
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public final void a(ayl com_tencent_mm_protocal_c_ayl) {
        this.nDt.a(8, com_tencent_mm_protocal_c_ayl, 0, 0);
    }
}
