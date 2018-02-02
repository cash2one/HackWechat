package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.b.c.b.4;
import com.tencent.mm.plugin.backup.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class c$b$4$1 implements e {
    final /* synthetic */ boolean kjR;
    final /* synthetic */ ad kjS;
    final /* synthetic */ 4 kjT;

    c$b$4$1(4 4, boolean z, ad adVar) {
        this.kjT = 4;
        this.kjR = z;
        this.kjS = adVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i(this.kjT.kjK.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[]{Boolean.valueOf(this.kjR), this.kjS, Integer.valueOf(i), Integer.valueOf(i2), str, this.kjT.kjK.kjC, ((d) kVar).kpc.kua});
        if (this.kjR && this.kjT.kjK.kjC.equals(r0)) {
            this.kjS.open();
        }
    }
}
