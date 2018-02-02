package com.tencent.mm.plugin.appbrand.debugger;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.1;

class p$1 implements Runnable {
    final /* synthetic */ p iRt;

    p$1(p pVar) {
        this.iRt = pVar;
    }

    public final void run() {
        RemoteDebugMoveView a = p.a(this.iRt);
        int width = this.iRt.getWidth();
        int height = this.iRt.getHeight();
        a.setLayoutParams(new LayoutParams(-2, -2));
        a.iQI = width;
        a.iQJ = height;
        a.post(new 1(a));
        this.iRt.addView(p.a(this.iRt));
    }
}
