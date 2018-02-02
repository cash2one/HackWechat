package com.tencent.mm.plugin.hce.a;

import com.tencent.mm.g.a.ib;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<ib> {
    public a() {
        this.xen = ib.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ib ibVar = (ib) bVar;
        if (!b.aSs()) {
            ibVar.fyz.errCode = 13000;
            ibVar.fyz.fnL = "not support NFC";
        } else if (b.aSr()) {
            ibVar.fyz.errCode = 0;
            ibVar.fyz.fnL = "support HCE and system NFC switch is opened";
        } else {
            ibVar.fyz.errCode = 13002;
            ibVar.fyz.fnL = "not support HCE";
        }
        return false;
    }
}
