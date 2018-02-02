package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ui.MMActivity;

class c$3 implements Runnable {
    final /* synthetic */ c jgI;

    c$3(c cVar) {
        this.jgI = cVar;
    }

    public final void run() {
        ((MMActivity) this.jgI.jgr.mContext).showVKB();
    }
}
