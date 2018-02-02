package com.tencent.mm.modelfriend;

import com.tencent.mm.g.a.fm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends c<fm> {
    public f() {
        this.xen = fm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fm fmVar = (fm) bVar;
        if (fmVar instanceof fm) {
            fmVar.fuN.fuQ = true;
            if (!bh.ov(m.kY(fmVar.fuM.fuO))) {
                fmVar.fuN.fuQ = false;
            } else if (bh.ov(m.kY(fmVar.fuM.fuP))) {
                x.i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
            } else {
                fmVar.fuN.fuQ = false;
            }
        }
        return false;
    }
}
