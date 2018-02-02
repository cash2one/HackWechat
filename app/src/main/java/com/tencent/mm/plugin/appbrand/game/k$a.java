package com.tencent.mm.plugin.appbrand.game;

import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.a;
import com.tencent.mm.plugin.appbrand.game.k.2;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$a {
    final /* synthetic */ k iXI;

    private k$a(k kVar) {
        this.iXI = kVar;
    }

    @JavascriptInterface
    public final int create(String str) {
        int i;
        synchronized (this.iXI) {
            if (!this.iXI.iXC || this.iXI.iXE == null) {
                x.e("MicroMsg.WAGameWeixinJSContextLogic", "create subContext failed. mStateReady = [%b] mSubContextAddon = [%s]", new Object[]{Boolean.valueOf(this.iXI.iXC), this.iXI.iXE});
                i = -1;
            } else {
                a adT = this.iXI.iXE.adT();
                k kVar = this.iXI;
                if (adT.adH()) {
                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "bindSubContext subContext = [" + adT + "]");
                } else if (kVar.iXG == null) {
                    x.e("MicroMsg.WAGameWeixinJSContextLogic", "initSubJSContext mBridgeHolder == null");
                } else {
                    kVar.iXG.a(adT, "WeixinJSContext");
                }
                String str2 = "";
                if (!kVar.adZ()) {
                    adT.addJavascriptInterface(new d(kVar.iXD, adT), "WeixinJSCore");
                    str2 = a.a(kVar.iXD.irP, "wxa_library/android.js", true);
                }
                x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject WAGameSubContext to SubContext");
                str2 = bh.ou(str2) + a.a(kVar.iXD.irP, "WAGameSubContext.js", false);
                g.pQN.a(778, 17, 1, false);
                h.a(adT, str2, new k$1(kVar));
                k kVar2 = this.iXI;
                if (!bh.ov(str)) {
                    String a = a.a(kVar2.iXD.irP, str, false);
                    if (bh.ov(a)) {
                        x.e("MicroMsg.WAGameWeixinJSContextLogic", "bussiness code is null [%s]", new Object[]{a});
                    } else {
                        x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject SubContext subContext.js");
                        g.pQN.a(778, 21, 1, false);
                        h.a(adT, str, a, new 2(kVar2));
                        q.a(kVar2.iXD.irP, adT, str);
                    }
                }
                x.i("MicroMsg.WAGameWeixinJSContextLogic", "create subContext success = [%d]", new Object[]{Integer.valueOf(adT.adI())});
                i = adT.adI();
            }
        }
        return i;
    }

    @JavascriptInterface
    public final void destroy(int i) {
        synchronized (this.iXI) {
            if (!this.iXI.iXC || this.iXI.iXE == null) {
                x.e("MicroMsg.WAGameWeixinJSContextLogic", "destroy subContext failed. mStateReady = [%b] mSubContextAddon = [%s] contextId = [%d]", new Object[]{Boolean.valueOf(this.iXI.iXC), this.iXI.iXE, Integer.valueOf(i)});
                return;
            }
            this.iXI.iXE.ke(i);
        }
    }
}
