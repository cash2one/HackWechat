package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c iRU;

    c$1(c cVar) {
        this.iRU = cVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.i("MicroMsg.DynamicPageViewIPCProxy", "getDynamicData result(errType : %s, errCode : %s, errMsg : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        g gVar = this.iRU.iRM;
        if (i == 0 && i2 == 0) {
            if (this.iRU.iRK == 1 && !this.iRU.iRQ) {
                this.iRU.iRQ = true;
                com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRU.iRN + "-" + this.iRU.appId, Integer.valueOf(9), Long.valueOf(System.currentTimeMillis())});
            }
            rr rrVar = (rr) bVar.hmh.hmo;
            String cdp = rrVar.vZC != null ? rrVar.vZC.cdp() : "";
            if (gVar != null) {
                if (!bh.ov(cdp)) {
                    gVar.field_data = cdp;
                }
                gVar.field_interval = rrVar.hXU;
                gVar.field_updateTime = System.currentTimeMillis();
                Bundle bundle = (Bundle) f.a("com.tencent.mm", gVar.vI(), com.tencent.mm.plugin.appbrand.dynamic.j.b.b.class);
                if (bundle != null) {
                    bundle.getBoolean("result", false);
                }
                if (this.iRU.Vx) {
                    c.a(this.iRU.gOM, gVar);
                    if (this.iRU.iRK == 1 && !this.iRU.iRR) {
                        this.iRU.iRR = true;
                        com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRU.iRN + "-" + this.iRU.appId, Integer.valueOf(11), Long.valueOf(System.currentTimeMillis())});
                    }
                    if (gVar.field_interval > 0) {
                        this.iRU.acD();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.DynamicPageViewIPCProxy", "not running");
                return;
            }
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(638, 0, 1, false);
        if (this.iRU.iRK == 1 && !this.iRU.iRQ) {
            com.tencent.mm.plugin.report.service.g.pQN.h(14452, new Object[]{this.iRU.iRN + "-" + this.iRU.appId, Integer.valueOf(10), Long.valueOf(System.currentTimeMillis())});
        }
        b.d(this.iRU.iRT, (gVar != null ? (long) gVar.field_interval : 10) * 1000);
    }
}
