package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.g;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j.b;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.protocal.c.aip;
import java.util.ArrayList;

class a$7 implements Runnable {
    final /* synthetic */ a jPj;

    a$7(a aVar) {
        this.jPj = aVar;
    }

    public final void run() {
        String str;
        ArrayList arrayList = null;
        int i = 0;
        ArrayList k = a.k(this.jPj).k(f.Zm().iKb.abd());
        a.p(this.jPj);
        int i2 = this.jPj.irz;
        String str2 = this.jPj.jKU;
        if (k == null || k.size() <= 0) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int i3 = 0;
            for (int i4 = 0; i4 < k.size(); i4++) {
                Object obj = k.get(i4);
                if (obj instanceof i) {
                    i3++;
                    stringBuilder.append(((i) obj).appId);
                    if (i3 == 20 || i3 >= k.size()) {
                        break;
                    }
                    stringBuilder.append(":#:");
                }
            }
            str = stringBuilder.toString();
        }
        String str3 = "";
        aip aaQ = g.aaQ();
        if (aaQ != null) {
            i = aaQ.kkv;
            str3 = aaQ.wpP;
        }
        a.a(i2, "", str, i, str3, str2);
        if (a.l(this.jPj)) {
            arrayList = f.Zn().jF(b.iJT);
        }
        this.jPj.runOnUiThread(new 1(this, arrayList, k));
        com.tencent.mm.plugin.appbrand.appusage.b.aaH().a(a.h(this.jPj).get(), true, a.q(this.jPj));
        a.r(this.jPj).set(true);
    }
}
