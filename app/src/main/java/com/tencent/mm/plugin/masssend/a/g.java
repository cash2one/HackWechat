package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class g extends c<lu> {
    public g() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (ar.Hj()) {
            h.aYE();
            ar.Hg();
            if (bh.bz(bh.a((Long) com.tencent.mm.z.c.CU().get(102409, null), 0)) > 900000) {
                h.aYE().aYz();
                h.aYE();
                c.dG(bh.Wp());
            } else {
                x.d("MicroMsg.PostTaskMassSendListener", "time limit");
            }
        } else {
            x.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
        }
        return false;
    }
}
