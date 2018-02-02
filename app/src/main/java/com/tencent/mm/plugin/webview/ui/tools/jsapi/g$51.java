package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.dg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class g$51 implements Runnable {
    final /* synthetic */ dg tIQ;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$51(g gVar, dg dgVar, i iVar) {
        this.tIj = gVar;
        this.tIQ = dgVar;
        this.tIg = iVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[]{Boolean.valueOf(this.tIQ.frM.frO), this.tIQ.frM.frP});
        if (!this.tIQ.frM.frO) {
            return;
        }
        if (bh.ov(this.tIQ.frM.frP)) {
            g.a(this.tIj, this.tIg, "getWXDeviceTicket:fail", null);
            return;
        }
        Map hashMap = new HashMap();
        x.i("MicroMsg.MsgHandler", "ticket %s", new Object[]{this.tIQ.frM.frP});
        hashMap.put("ticket", this.tIQ.frM.frP);
        g.a(this.tIj, this.tIg, "getWXDeviceTicket:ok", hashMap);
    }
}
