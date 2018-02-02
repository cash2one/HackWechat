package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.x;

class p$2 implements Runnable {
    final /* synthetic */ p iRt;

    p$2(p pVar) {
        this.iRt = pVar;
    }

    public final void run() {
        if (p.b(this.iRt) == null) {
            x.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
        } else if (p.c(this.iRt)) {
            this.iRt.setVisibility(0);
            if (p.b(this.iRt).indexOfChild(this.iRt) == -1) {
                p.b(this.iRt).addView(this.iRt);
            }
            p.b(this.iRt).bringChildToFront(this.iRt);
            this.iRt.setBackgroundColor(this.iRt.getContext().getResources().getColor(d.bsK));
        } else {
            this.iRt.setBackgroundColor(this.iRt.getContext().getResources().getColor(d.transparent));
        }
    }
}
