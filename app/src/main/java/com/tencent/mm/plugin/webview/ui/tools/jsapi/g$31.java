package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.cl;
import com.tencent.mm.sdk.platformtools.x;

class g$31 implements Runnable {
    final /* synthetic */ cl sYP;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$31(g gVar, cl clVar, i iVar) {
        this.tIj = gVar;
        this.sYP = clVar;
        this.tIg = iVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "run ecard jsapi check callback");
        if (this.sYP.fqC.retCode == 0) {
            g.a(this.tIj, this.tIg, "openECard:ok", null);
        } else {
            g.a(this.tIj, this.tIg, "openECard:fail", null);
        }
    }
}
