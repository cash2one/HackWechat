package com.tencent.mm.plugin.welab;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

public final class c implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.hmq == null || aVar.hmq.vGZ == null) {
            x.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            return;
        }
        String a = n.a(aVar.hmq.vGZ);
        x.i("MicroMsg.WelabNewMsgLsn", "recv addMsg " + a);
        com.tencent.mm.sdk.e.c Qy = g.Qy(a);
        if (Qy != null && Qy.isValid()) {
            if (Qy.field_status == 1) {
                b.bVu().tPx.a(Qy, new String[]{"expId"});
            } else {
                b.bVu().tPx.c(Qy);
                b.bVJ().f(Qy);
                g.pQN.a((long) Qy.field_idkey, (long) Qy.field_idkeyValue, 1, false);
            }
            e.o(Qy.field_LabsAppId, 6, false);
        }
    }
}
