package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.sq;
import java.util.HashMap;
import java.util.Map;

class g$29 implements Runnable {
    final /* synthetic */ sq sDH;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$29(g gVar, sq sqVar, i iVar) {
        this.tIj = gVar;
        this.sDH = sqVar;
        this.tIg = iVar;
    }

    public final void run() {
        if (this.sDH.fKv.retCode == 0) {
            Map hashMap = new HashMap();
            hashMap.put("buffer", this.sDH.fKv.buffer);
            g.a(this.tIj, this.tIg, "handleWCPayWalletBuffer:ok", hashMap);
        } else if (this.sDH.fKv.retCode == -2) {
            g.a(this.tIj, this.tIg, "handleWCPayWalletBuffer:null", null);
        } else {
            g.a(this.tIj, this.tIg, "handleWCPayWalletBuffer:fail", null);
        }
    }
}
