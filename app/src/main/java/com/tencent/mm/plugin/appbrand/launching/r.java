package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.i.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class r extends p {
    final String appId;
    final int fvM;
    final String iEF;

    r(String str, String str2, int i) {
        super(new o(str, str2));
        this.appId = str;
        this.iEF = str2;
        this.fvM = i;
    }

    public final String ahX() {
        return String.format(Locale.US, "appId %s, module %s, pkgType %d", new Object[]{this.appId, this.iEF, Integer.valueOf(this.fvM)});
    }

    public final void prepare() {
        int i = -1;
        Pair p = ad.p(this.jxU.toString(), this.fvM, 1);
        if (p.second != null) {
            d((WxaPkgWrappingInfo) p.second);
            return;
        }
        String ah;
        if (bh.ov(this.iEF)) {
            ah = f.Zo().ah(this.appId, this.fvM);
        } else {
            ae a = f.Zo().a(this.jxU.toString(), this.fvM, new String[]{"versionMd5"});
            if (a == null) {
                x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[]{ahX()});
                ah = null;
            } else {
                a a2 = c.a(new com.tencent.mm.plugin.appbrand.appcache.c(this.appId, this.iEF, a.field_versionMd5, this.fvM));
                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                    x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[]{Integer.valueOf(((agq) a2.fJJ).wob), ((agq) a2.fJJ).woa, ((agq) a2.fJJ).htu});
                    if (bh.ov(((agq) a2.fJJ).htu)) {
                        if (((agq) a2.fJJ).wob == -1001) {
                            AppBrand404PageUI.show(j.iBc);
                            com.tencent.mm.plugin.appbrand.report.a.z(this.appId, 4, this.fvM + 1);
                        } else {
                            y.ta(com.tencent.mm.plugin.appbrand.q.c.getMMString(j.iAW, new Object[]{Integer.valueOf(5), Integer.valueOf(((agq) a2.fJJ).wob)}));
                        }
                    }
                    ah = ((agq) a2.fJJ).htu;
                } else {
                    String str = "MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode";
                    String str2 = "%s, cgi failed, %d %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = ahX();
                    objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    objArr[2] = Integer.valueOf(a2 == null ? -1 : a2.errCode);
                    x.e(str, str2, objArr);
                    int i2 = j.iAT;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    if (a2 != null) {
                        i = a2.errCode;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    y.ta(y.getMMString(i2, objArr2));
                    ah = null;
                }
            }
        }
        aj.a 1 = new 1(this, this.fvM);
        x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[]{ahX(), ah});
        if (bh.ov(ah)) {
            d(null);
        } else if (!aj.b(this.jxU.toString(), this.fvM, 1, ah, 1)) {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[]{ahX()});
            d(null);
        }
    }
}
