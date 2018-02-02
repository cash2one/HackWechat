package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class i$3 implements a {
    final /* synthetic */ i nDs;

    i$3(i iVar) {
        this.nDs = iVar;
    }

    public final void a(d.a aVar) {
        x.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
        String a = n.a(aVar.hmq.vGZ);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
            return;
        }
        Map y = bi.y(a, "sysmsg");
        if (y == null) {
            x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
        } else if (y.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
            x.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[]{Integer.valueOf(bh.getInt((String) y.get(".sysmsg.WCONotify.NotifyGetBalance"), 0))});
            if (bh.getInt((String) y.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                ar.CG().a(new g(2), 0);
            }
        }
    }
}
