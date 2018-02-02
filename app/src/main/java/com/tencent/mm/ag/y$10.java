package com.tencent.mm.ag;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;

class y$10 implements a {
    final /* synthetic */ y hqy;

    y$10(y yVar) {
        this.hqy = yVar;
    }

    public final void a(ae aeVar, as asVar) {
        if (aeVar != null && !bh.ov(aeVar.field_username)) {
            String str = aeVar.field_username;
            x WO = ((h) g.h(h.class)).EY().WO(str);
            if (WO != null && WO.cia() && !s.gR(str)) {
                d jK = y.Mf().jK(str);
                if (jK.xjy == -1) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                } else if (jK.Lf()) {
                    if (jK.bI(false) == null) {
                        aeVar.dH(null);
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                    } else if (jK.bI(false).LG() == null) {
                        aeVar.dH(null);
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                    } else if (jK.Lg()) {
                        aeVar.dH(null);
                    } else {
                        aeVar.dH(bh.ou(jK.Lm()));
                        if (bh.ov(jK.Lm())) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", new Object[]{aeVar.field_username});
                        }
                    }
                } else if (jK.Lb() || jK.Le() || s.hl(str)) {
                    aeVar.dH(null);
                } else {
                    aeVar.dH("officialaccounts");
                }
            }
        }
    }
}
