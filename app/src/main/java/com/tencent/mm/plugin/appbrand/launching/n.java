package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.plugin.appbrand.launching.k.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class n implements j {
    final String appId;
    final int iKd;
    final String iNW;
    final List<e> iPI;
    final String iPK;
    final int jxO;
    final int jxP;
    final int jxz;

    public /* synthetic */ Object call() {
        String str;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        h hVar = new h();
        final h hVar2 = new h();
        k f = a.f(this.appId, "__APP__", this.iKd, this.jxO);
        f.a(new 1(this, hVar, countDownLatch));
        f.prepareAsync();
        String uB = bh.ov(this.iNW) ? "" : l.uB(this.iNW);
        if (bh.ov(uB)) {
            str = this.iPK;
        } else {
            String str2;
            for (e eVar : this.iPI) {
                if (uB.startsWith(eVar.name)) {
                    str2 = eVar.name;
                    break;
                }
            }
            str2 = null;
            str = bh.ov(str2) ? this.iPK : str2;
        }
        if ("__APP__".equals(str) || bh.ov(str)) {
            countDownLatch.countDown();
            Object obj = null;
        } else {
            k f2 = a.f(this.appId, str, this.iKd, this.jxO);
            f2.a(new k$b(this) {
                final /* synthetic */ n jxR;

                public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    hVar2.jRK = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                }
            });
            f2.prepareAsync();
            int i = 1;
        }
        countDownLatch.await();
        if (hVar.jRK == null) {
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) hVar.jRK;
        for (e eVar2 : this.iPI) {
            if (!"__APP__".equals(eVar2.name)) {
                ModulePkgInfo modulePkgInfo = new ModulePkgInfo();
                modulePkgInfo.name = eVar2.name;
                modulePkgInfo.fqR = eVar2.fqR;
                wxaPkgWrappingInfo.iGO.add(modulePkgInfo);
            }
        }
        if (obj == null) {
            return wxaPkgWrappingInfo;
        }
        if (hVar2.jRK == null) {
            return null;
        }
        for (e eVar22 : this.iPI) {
            ModulePkgInfo modulePkgInfo2 = new ModulePkgInfo();
            modulePkgInfo2.fqR = eVar22.fqR;
            modulePkgInfo2.name = eVar22.name;
            if (str.equals(eVar22.name)) {
                modulePkgInfo2.iEa = ((WxaPkgWrappingInfo) hVar2.jRK).iEa;
            }
        }
        return wxaPkgWrappingInfo;
    }

    n(String str, int i, String str2, int i2, int i3, int i4, String str3, List<e> list) {
        this.appId = str;
        this.iKd = i;
        this.iNW = str2;
        this.jxz = i2;
        this.jxO = i3;
        this.jxP = i4;
        this.iPK = str3;
        this.iPI = list;
    }

    public final void kO(int i) {
    }
}
