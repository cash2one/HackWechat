package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.k.a;
import com.tencent.mm.sdk.platformtools.x;

class h$2 extends a {
    final /* synthetic */ h lMA;
    final /* synthetic */ h.a lMB;

    h$2(h hVar, h.a aVar) {
        this.lMA = hVar;
        this.lMB = aVar;
    }

    public final void a(long j, int i, int i2, int i3, long j2) {
        x.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)});
        f.a cA = h.a(this.lMA).cA(j);
        if (cA != null) {
            cA.fsg = i2;
            cA.kxJ = j2;
        } else {
            x.i(h.TAG, "get connect state faild : %d", new Object[]{Long.valueOf(j)});
        }
        this.lMB.a(j, i, i2, i3, j2);
    }
}
