package com.tencent.mm.az;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.bo;
import com.tencent.smtt.sdk.QbSdk;

public final class o extends c<lu> {
    public o() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (bh.by(bh.a((Long) g.Dj().CU().get(66818, null), 0)) * 1000 > 1800000) {
            int a = bh.a((Integer) g.Dj().CU().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                bo.r(9, String.valueOf(a));
                g.Dj().CU().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            g.Dj().CU().set(66818, Long.valueOf(bh.Wo()));
        }
        return false;
    }
}
