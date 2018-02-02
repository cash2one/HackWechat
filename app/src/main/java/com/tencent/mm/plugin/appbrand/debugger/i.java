package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.j.a;
import com.tencent.mm.protocal.c.bvr;
import com.tencent.mm.protocal.c.bwg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.d;
import java.net.URL;
import java.util.Iterator;

public final class i implements b {
    n iQA;
    k iQB = new k();
    p iQC;
    a iQD = new 2(this);
    g iQx;
    String iQy;
    Activity iQz;
    j iqB;

    static /* synthetic */ void a(i iVar) {
        x.i("MicroMsg.RemoteDebugJsEngine", "login");
        iVar.iQx.eQ(1);
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bwg = new bwg();
        com_tencent_mm_protocal_c_bwg.wXj = iVar.iQx.iPU;
        com_tencent_mm_protocal_c_bwg.wnw = iVar.iQx.aci();
        iVar.iQA.a(o.a(1002, com_tencent_mm_protocal_c_bwg));
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iQx.acl()) {
            if (this.iQx.is()) {
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_bvr = new bvr();
                com_tencent_mm_protocal_c_bvr.wWY = this.iQx.iQf.incrementAndGet();
                com_tencent_mm_protocal_c_bvr.script = str;
                this.iQB.a(o.a(com_tencent_mm_protocal_c_bvr, this.iQx, "evaluateJavascript"));
                int i = com_tencent_mm_protocal_c_bvr.wWY;
                a aVar = new a();
                if (bh.ov(this.iQy)) {
                    aVar.fok = l.rh(str);
                } else {
                    aVar.fok = this.iQy;
                    this.iQy = null;
                }
                aVar.iPS = System.currentTimeMillis();
                aVar.size = str.length();
                aVar.iPR = valueCallback;
                this.iQx.iQo.put(Integer.valueOf(i), aVar);
                return;
            }
            this.iQx.iQk.add(new Pair(str, valueCallback));
            this.iQy = null;
        }
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback);
    }

    public final void a(d dVar) {
    }

    public final void destroy() {
        this.iQB.quit();
        this.iQB.act();
    }

    public final <T extends c> T v(Class<T> cls) {
        return null;
    }

    final void connect() {
        if (this.iQA == null) {
            this.iQA = new n(this.iqB.mAppId);
            k kVar = this.iQB;
            n nVar = this.iQA;
            g gVar = this.iQx;
            Context context = this.iQz;
            com.tencent.mm.plugin.appbrand.jsapi.d dVar = this.iqB.irQ;
            p pVar = this.iQC;
            kVar.iQA = nVar;
            kVar.iQx = gVar;
            kVar.mContext = context;
            kVar.irQ = dVar;
            kVar.iQC = pVar;
        }
        if (this.iQx.acn()) {
            this.iQA.a("ws://localhost:" + this.iQx.iPZ.iQw, this.iQD);
        } else {
            this.iQA.a("wss://wxagame.weixin.qq.com/remote/", this.iQD);
        }
    }

    final void onReady() {
        x.i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.iQx.eQ(3);
        x.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator it = this.iQx.iQk.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            evaluateJavascript((String) pair.first, (ValueCallback) pair.second);
        }
        this.iQx.iQk.clear();
        this.iQB.bB(this.iQx.acj(), 0);
        this.iQC.acB();
    }
}
