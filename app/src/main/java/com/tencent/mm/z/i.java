package com.tencent.mm.z;

import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ba.a;
import junit.framework.Assert;

public final class i {
    public static void fZ(String str) {
        Assert.assertTrue(!bh.ov(str));
        af WO = ((h) g.h(h.class)).EY().WO(str);
        if (WO != null && !bh.ov(WO.field_username)) {
            WO.setType(WO.field_type | 2048);
            s.t(WO);
            if (((h) g.h(h.class)).Fd().WY(str) == null && WO.cia()) {
                if (f.jU(str)) {
                    ae aeVar;
                    if (((h) g.h(h.class)).Fd().WY("officialaccounts") == null) {
                        aeVar = new ae("officialaccounts");
                        aeVar.ciy();
                        ((h) g.h(h.class)).Fd().d(aeVar);
                    }
                    aeVar = new ae(str);
                    aeVar.aj(System.currentTimeMillis());
                    aeVar.dH("officialaccounts");
                    ((h) g.h(h.class)).Fd().d(aeVar);
                } else if (f.jW(str) && !f.eE(str)) {
                    ae aeVar2;
                    d jS = f.jS(str);
                    if (((h) g.h(h.class)).Fd().WY(jS.field_enterpriseFather) == null) {
                        aeVar2 = new ae(jS.field_enterpriseFather);
                        aeVar2.ciy();
                        ((h) g.h(h.class)).Fd().d(aeVar2);
                    }
                    aeVar2 = new ae(str);
                    aeVar2.aj(System.currentTimeMillis());
                    aeVar2.dH(jS.Lm());
                    ((h) g.h(h.class)).Fd().d(aeVar2);
                }
                x.i("MicroMsg.BizConversationLogic", "setPlacedTop username = " + str);
            }
            ((h) g.h(h.class)).Fd().Xd(str);
        }
    }

    public static int a(String str, long j, a aVar) {
        x.d("MicroMsg.BizConversationLogic", "deleteMsgByBizChatId %s", new Object[]{Long.valueOf(j)});
        g.Dm().F(new 1(str, j, aVar));
        return 0;
    }
}
