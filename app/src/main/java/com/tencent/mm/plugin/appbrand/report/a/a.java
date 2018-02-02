package com.tencent.mm.plugin.appbrand.report.a;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class a implements d {
    private final e irP;
    public boolean jDf = false;
    public Intent jHm;
    public boolean jHn = false;
    g jHo = null;
    private i jHp = null;
    public n jHq = null;
    public volatile e jHr = null;
    private final String mAppId;

    public a(e eVar) {
        this.mAppId = eVar.mAppId;
        this.irP = eVar;
        abT();
    }

    public final void abT() {
        if (!bh.ov(this.mAppId)) {
            h e = h.e(this.irP);
            if (e != null) {
                String str = e.irG;
                AppBrandLaunchReferrer YL = e.YL();
                String str2 = "";
                if (1 == YL.iOd || 3 == YL.iOd) {
                    str2 = YL.appId;
                } else if (2 == YL.iOd) {
                    str2 = YL.url;
                }
                this.jHr = new c(str2);
                this.jHo = g.a(this.irP, str, this.jHr);
                LinkedList linkedList = new LinkedList();
                linkedList.push(bh.ou(str2));
                this.jHq = n.a(this.irP, str, linkedList);
                this.jHp = i.b(this.irP, str, this.jHr);
                return;
            }
        }
        x.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", new Object[]{bh.i(new Throwable())});
        this.jHr = e.jHI;
        this.jHp = i.akb();
        this.jHo = g.aka();
        this.jHq = n.akd();
    }

    public final void a(p pVar, p pVar2, aa aaVar) {
        p pVar3;
        if (aa.jFJ == aaVar) {
            abT();
        }
        Object obj = (aa.jFJ == aaVar || pVar2 == null || bh.ov(pVar2.aeO()) || pVar2 == pVar) ? 1 : null;
        e eVar = this.jHr;
        if (obj != null) {
            pVar3 = null;
        } else {
            pVar3 = pVar2;
        }
        eVar.a(pVar, pVar3, aaVar);
        if (obj == null) {
            pVar2.jEc.r(new 1(this, pVar, pVar2));
        } else {
            a(pVar, null);
        }
    }

    final void a(p pVar, p pVar2) {
        if (pVar2 != null) {
            g gVar = this.jHo;
            pVar.aeO();
            gVar.i(pVar2);
            gVar.wW();
            n nVar = this.jHq;
            String aeO = pVar.aeO();
            nVar.jIc = (String) nVar.jIV.peekFirst();
            nVar.jId = 2;
            nVar.jIe = aeO;
            nVar.jIV.push(pVar2.getURL());
            nVar.jIU = pVar2.getURL();
            nVar.k(pVar2);
        }
        this.jHp.j(pVar);
    }

    public final void d(p pVar) {
        this.jDf = true;
        this.jHr.d(pVar);
        pVar.jEc.r(new 2(this, pVar));
    }

    public final void e(p pVar) {
        this.jHm = null;
        if (this.jHn) {
            this.jHn = false;
            return;
        }
        this.jHr.e(pVar);
        this.jHp.j(pVar);
    }

    public final void g(long j, int i) {
        AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(this.mAppId);
        int i2 = oS == null ? 0 : oS.iOI.iGL;
        g.pQN.h(13543, new Object[]{this.mAppId, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)});
    }
}
