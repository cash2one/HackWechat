package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.nc;
import com.tencent.mm.plugin.sns.model.aa;
import com.tencent.mm.plugin.sns.model.aa.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends c<nc> {
    public k() {
        this.xen = nc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nc ncVar = (nc) bVar;
        if (ncVar instanceof nc) {
            if (ncVar.fFc.state == 0) {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                aa.nSI = true;
                aa aaVar = new aa();
                aaVar.qUV = System.currentTimeMillis();
                if (!aaVar.qUU) {
                    new a(aaVar).m(new String[]{""});
                }
            } else {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                aa.nSI = false;
            }
            return true;
        }
        x.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        return false;
    }
}
