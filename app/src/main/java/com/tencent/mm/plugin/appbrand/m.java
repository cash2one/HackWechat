package com.tencent.mm.plugin.appbrand;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.g.a.f;
import com.tencent.mm.plugin.appbrand.g.a.h;
import com.tencent.mm.plugin.appbrand.g.a.i;
import com.tencent.mm.plugin.appbrand.g.a.i.3;
import com.tencent.mm.plugin.appbrand.g.a.j;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    j iqB;
    d isb;
    public i isc;
    private j isd = new 1(this);

    public m(j jVar) {
        this.iqB = jVar;
        this.isb = (d) jVar.irR.v(d.class);
        this.isc = new i(this.isd);
        jVar.irR.addJavascriptInterface(this, "WeixinWorker");
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int create(String str) {
        Pair pair;
        String uy = c.uy("wxa_library/bootstrap_j2v8_worker.js");
        String format = String.format("var __wxConfig = %s;", new Object[]{this.iqB.YT().toString()});
        String pE = v.pE("WAWorker.js");
        String a = ah.a(this.iqB.irP, str);
        if ((!a.jv(this.iqB.irP.iqx.iOI.iGK) ? 1 : 0) != 0) {
            String a2 = ah.a(this.iqB.irP, str + ".map");
            if (a2 != null && a2.length() > 0) {
                pair = new Pair(null, a2);
                x.i("MicroMsg.AppBrandWorkerContainer", "injectSourceMap(%s.map)", new Object[]{str});
                return this.isc.a(new Pair[]{new Pair(null, uy), new Pair(null, format), new Pair(null, pE), new Pair(q.rl(str), a), pair});
            }
        }
        pair = null;
        return this.isc.a(new Pair[]{new Pair(null, uy), new Pair(null, format), new Pair(null, pE), new Pair(q.rl(str), a), pair});
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void terminate(int i) {
        f fVar = (f) this.isc.jwC.remove(Integer.valueOf(i));
        if (fVar != null) {
            fVar.jwo.p(new Runnable(fVar) {
                final /* synthetic */ f jwq;

                {
                    this.jwq = r1;
                }

                public final void run() {
                    this.jwq.jwn.release();
                }
            });
            h hVar = fVar.jwo;
            synchronized (hVar.jwm) {
                hVar.Vx = false;
            }
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void postMsgToWorker(int i, String str) {
        i iVar = this.isc;
        f fVar = (f) iVar.jwC.get(Integer.valueOf(i));
        if (fVar != null) {
            fVar.jwo.p(new 3(iVar, fVar, str));
        }
    }
}
