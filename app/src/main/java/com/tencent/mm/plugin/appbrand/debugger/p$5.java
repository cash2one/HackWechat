package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.j;

class p$5 implements Runnable {
    final /* synthetic */ p iRt;

    p$5(p pVar) {
        this.iRt = pVar;
    }

    public final void run() {
        if (p.e(this.iRt).acl()) {
            p.f(this.iRt).setImageResource(f.itg);
            p.g(this.iRt).setText(this.iRt.getContext().getString(j.iBf));
        } else if (p.e(this.iRt).is()) {
            p.f(this.iRt).setImageResource(f.itg);
            p.g(this.iRt).setText(this.iRt.getContext().getString(j.iBg));
        } else {
            p.f(this.iRt).setImageResource(f.itf);
            p.g(this.iRt).setText(this.iRt.getContext().getString(j.iBe));
        }
        p.h(this.iRt);
    }
}
