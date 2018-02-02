package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aj$a;
import com.tencent.mm.plugin.appbrand.appcache.aj$a.a;
import com.tencent.mm.plugin.appbrand.appcache.aj$a.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;

abstract class o implements aj$a {
    final int iKd;

    abstract String ahW();

    abstract void c(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    o(int i) {
        this.iKd = i;
    }

    public final void a(String str, b bVar, a aVar) {
        x.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdatingCallback, appId = %s, return = %s", new Object[]{ahW(), str, bVar.name()});
        if (b.iGB.equals(bVar)) {
            WxaPkgWrappingInfo pO = WxaPkgWrappingInfo.pO(aVar.filePath);
            if (pO == null) {
                x.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdatingCallback, ret=OK but obtain null appPkgInfo");
            } else {
                pO.iGL = aVar.version;
                pO.iGM = c.alI();
                pO.iGK = aVar.iGA;
            }
            c(pO);
            return;
        }
        if (b.iGG.equals(bVar)) {
            y.kP(j.iAZ);
            com.tencent.mm.plugin.appbrand.report.a.z(str, 23, this.iKd + 1);
        } else {
            y.ta(c.getMMString(j.iAW, Integer.valueOf(2), Integer.valueOf(bVar.code)));
        }
        c(null);
    }
}
