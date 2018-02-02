package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.dq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$33 extends c<dq> {
    final /* synthetic */ g tIj;

    g$33(g gVar) {
        this.tIj = gVar;
        this.xen = dq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dq dqVar = (dq) bVar;
        if (dqVar != null && (dqVar instanceof dq)) {
            x.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(dqVar.fsn.fso)});
            if (dqVar.fsn.fso != 10 && dqVar.fsn.fso == 12 && g.t(this.tIj)) {
                g.a(this.tIj, g.u(this.tIj), new int[]{1});
            }
        }
        return false;
    }
}
