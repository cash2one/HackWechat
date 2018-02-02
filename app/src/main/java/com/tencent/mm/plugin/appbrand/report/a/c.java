package com.tencent.mm.plugin.appbrand.report.a;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.a.e.a;
import com.tencent.mm.plugin.appbrand.report.a.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.Deque;
import java.util.LinkedList;

final class c implements d, e {
    private final String jHC;
    private final SparseArray<a> jHD = new SparseArray();
    private final Deque<a> jHE = new LinkedList();
    private boolean jHF = true;
    private String jHG;
    private a jHH;

    c(String str) {
        this.jHC = str;
    }

    private synchronized void b(p pVar, p pVar2) {
        boolean ub = ub(pVar2.aeO());
        this.jHH = g(pVar2);
        this.jHH.jHK = new com.tencent.mm.plugin.appbrand.report.a.e.c(1, pVar.aeO());
        int hashCode = pVar.hashCode();
        while (!isEmpty() && ajU().jHJ != hashCode) {
            ajT();
        }
        if (ub) {
            a(new a(pVar));
        }
        g(pVar).jHL = new b(pVar2.aeO());
        g(pVar).jHK = null;
    }

    private synchronized void f(p pVar) {
        this.jHG = pVar.aeO();
        this.jHF = false;
        a(new a(pVar));
        ajU().jHL = bh.ov(this.jHC) ? null : new b(this.jHC);
    }

    private synchronized void ajS() {
        this.jHH = null;
        this.jHG = null;
        this.jHF = false;
    }

    public final void a(p pVar, p pVar2, aa aaVar) {
        synchronized (this) {
            if (this.jHF) {
                f(pVar);
            } else if (aaVar == aa.jFG) {
                b(pVar, pVar2);
            } else {
                if (this.jHH != null) {
                    ajS();
                }
                if (pVar2 != null) {
                    a g = g(pVar2);
                    if (g != null) {
                        g.jHK = new com.tencent.mm.plugin.appbrand.report.a.e.c(2, pVar.aeO());
                    }
                }
                a aVar = new a(pVar);
                aVar.jHL = pVar2 == null ? null : new b(pVar2.aeO());
                a(aVar);
            }
        }
    }

    public final void d(p pVar) {
        int i = 1;
        String str = null;
        synchronized (this) {
            a g = g(pVar);
            if (g == null) {
                return;
            }
            switch (1.iHw[com.tencent.mm.plugin.appbrand.c.pe(pVar.mAppId).ordinal()]) {
                case 1:
                    if (!pVar.jEc.ic()) {
                        i = 3;
                        break;
                    } else {
                        i = 4;
                        break;
                    }
                case 2:
                    if (pVar.jEc.ic()) {
                        i = 5;
                        break;
                    }
                    break;
                case 3:
                    i = 6;
                    break;
                case 4:
                    i = 9;
                    str = i.pl(pVar.mAppId).irN + ":" + URLEncoder.encode(bh.ou(i.pl(pVar.mAppId).irO));
                    break;
                default:
                    Intent intent = pVar.irP.iqC.jDm.jHm;
                    if (intent == null) {
                        i = 7;
                        break;
                    }
                    if (intent.getComponent() == null) {
                        x.e("MicroMsg.AppBrandPageVisitStack", "onBackground, intent %s, get null cmp name", new Object[]{intent});
                        str = "";
                    } else {
                        str = intent.getComponent().getClassName();
                    }
                    if (!str.contains("WebViewUI")) {
                        i = 8;
                        str = bh.az(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                        break;
                    }
                    i = 10;
                    str = intent.getStringExtra("appbrand_report_key_target_url");
                    break;
            }
            g.jHK = new com.tencent.mm.plugin.appbrand.report.a.e.c(i, str);
        }
    }

    private a g(p pVar) {
        a ajU = ajU();
        if (ajU == null) {
            return new a(pVar);
        }
        if (ajU.jHJ == pVar.hashCode()) {
            return ajU;
        }
        x.printErrStackTrace("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
        return ajU;
    }

    public final synchronized void e(p pVar) {
        if (this.jHF) {
            f(pVar);
        } else {
            ajS();
        }
    }

    private synchronized void a(a aVar) {
        this.jHE.offerFirst(aVar);
        this.jHD.put(aVar.jHJ, aVar);
    }

    private synchronized a ajT() {
        a aVar;
        aVar = (a) this.jHE.pollFirst();
        if (aVar != null) {
            this.jHD.remove(aVar.jHJ);
        }
        return aVar;
    }

    public final synchronized a ajU() {
        return (a) this.jHE.peekFirst();
    }

    private synchronized boolean isEmpty() {
        return this.jHE.isEmpty();
    }

    public final synchronized boolean ub(String str) {
        boolean z;
        z = !bh.ov(this.jHG) && this.jHG.equals(str);
        return z;
    }

    public final synchronized a h(p pVar) {
        a aVar;
        aVar = (a) this.jHD.get(pVar.hashCode());
        if (aVar == null && this.jHH != null && this.jHH.jHJ == pVar.hashCode()) {
            aVar = this.jHH;
        }
        return aVar;
    }
}
