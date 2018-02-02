package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.game.d.4;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    final /* synthetic */ d iXf;

    d$1(d dVar) {
        this.iXf = dVar;
    }

    public final void run() {
        this.iXf.iXc = System.currentTimeMillis();
        this.iXf.YS();
        if (this.iXf.irP != null) {
            this.iXf.irP.iqM.o(10, System.currentTimeMillis() - this.iXf.iXc);
        }
        j jVar = this.iXf;
        if (jVar.irR == null) {
            x.e("MicroMsg.WAGameAppService", "initSubContext Error. Engine == null");
        } else {
            jVar.iXd = System.currentTimeMillis();
            k kVar = jVar.iXb;
            synchronized (kVar) {
                if (kVar.iXC) {
                    a aVar = kVar.iXF;
                    if (aVar == null || !aVar.adH()) {
                        x.e("MicroMsg.WAGameWeixinJSContextLogic", "bindMainJSContext Main Context is [" + aVar + "]");
                    } else {
                        kVar.iXG = kVar.iXE.adT();
                        if (kVar.iXG == null) {
                            x.e("MicroMsg.WAGameWeixinJSContextLogic", "injectWeixinJSContextLogic error. Alloc bridge holder failed.");
                        } else {
                            aVar.addJavascriptInterface(new k.a(kVar, (byte) 0), "WeixinJSContext");
                            aVar.a(kVar.iXG, "WeixinJSContext");
                        }
                    }
                } else {
                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "injectWeixinJSContextLogic error. mStateReady is not true.");
                }
            }
            x.i("MicroMsg.WAGameAppService", "Inject WAGame to MainContext");
            String str = a.a(jVar.irP, "wxa_library/android.js", true) + a.a(jVar.irP, "wxa_library/NativeGlobal.js", true) + a.a(jVar.irP, "WAGame.js", false);
            g.pQN.a(778, 13, 1, false);
            h.a(jVar.irR, str, new 4(jVar));
        }
        if (!this.iXf.adG()) {
            jVar = this.iXf;
            jVar.iXe = System.currentTimeMillis();
            str = a.a(jVar.irP, "game.js", false);
            g.pQN.a(778, 25, 1, false);
            x.i("MicroMsg.WAGameAppService", "Inject jsMainContext game.js");
            h.a(jVar.irR, "game.js", str, new d$5(jVar));
            q.a(jVar.irP, jVar.irR, "game.js");
        }
        this.iXf.YO();
    }
}
