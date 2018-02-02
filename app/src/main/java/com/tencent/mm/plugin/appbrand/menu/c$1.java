package com.tencent.mm.plugin.appbrand.menu;

import a.a;
import com.tencent.mm.plugin.appbrand.page.p;

class c$1 implements Runnable {
    final /* synthetic */ c jAx;
    final /* synthetic */ p jfB;

    c$1(c cVar, p pVar) {
        this.jAx = cVar;
        this.jfB = pVar;
    }

    public final void run() {
        try {
            if (this.jfB.jDS != null) {
                a.cB(this.jfB.jDS.getX5WebViewExtension()).n("notifyMemoryPressure", new Object[]{Integer.valueOf(80)});
            }
        } catch (Exception e) {
        }
    }
}
