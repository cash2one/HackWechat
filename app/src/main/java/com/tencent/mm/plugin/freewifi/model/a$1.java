package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bh;

class a$1 implements e {
    final /* synthetic */ a mDU;

    a$1(a aVar) {
        this.mDU = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = ((b) kVar).mac;
        if (!m.AA(str2)) {
            if (i2 == -30011) {
                this.mDU.mDS.put(str2.hashCode(), Long.valueOf(bh.Wp()));
            } else {
                this.mDU.mDS.remove(str2.hashCode());
            }
        }
    }
}
