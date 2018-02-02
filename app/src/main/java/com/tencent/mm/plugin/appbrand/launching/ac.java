package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class ac extends x<Pair<WxaAttributes, Boolean>> {
    private String appId;
    private final int iKd;
    private final String iNW;
    private final int jxz;
    private final int jyp;
    private String username;

    public final /* synthetic */ Object call() {
        return aic();
    }

    ac(String str, String str2, int i, int i2, int i3, String str3) {
        this.username = str;
        this.appId = str2;
        this.iKd = i;
        this.jyp = i2;
        this.jxz = i3;
        this.iNW = str3;
    }

    public final Pair<WxaAttributes, Boolean> aic() {
        boolean z;
        boolean z2;
        String oVar;
        Pair P;
        boolean z3 = true;
        if (bh.ov(this.username)) {
            z = false;
        } else {
            this.appId = q.qQ(this.username);
            z = bh.ov(this.appId);
        }
        if (z) {
            z2 = z;
        } else {
            if (h.ZI()) {
                WxaAttributes f = f.Zh().f(this.appId, new String[]{"versionInfo"});
                z = (f == null || f.acb() == null || !f.acb().iPJ) ? false : true;
            } else {
                z = false;
            }
            oVar = z ? new o(this.appId, "__APP__").toString() : this.appId;
            if (this.iKd == 0) {
                ae a = f.Zo().a(oVar, 0, new String[]{"version", "pkgPath", "versionMd5"});
                if (a == null) {
                    x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, get null manifest record by appId %s, forceSync", new Object[]{oVar});
                    z = true;
                } else if (this.jyp <= 0 || this.jyp <= a.field_version) {
                    boolean z4 = e.bO(a.field_pkgPath) && a.field_versionMd5.equals(g.bV(a.field_pkgPath));
                    if (!z4) {
                        b.deleteFile(a.field_pkgPath);
                    }
                    if (!bh.ov(this.iNW)) {
                        z = z4 && f.bq(a.field_pkgPath, this.iNW);
                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, latestPkgExists[%B], enterPath[%s], pathAccessible[%B]", new Object[]{Boolean.valueOf(z4), this.iNW, Boolean.valueOf(z)});
                        z = !z;
                    } else if (z4) {
                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "local available pkg version[%d] LATEST, no need force update", new Object[]{Integer.valueOf(a.field_version)});
                    } else {
                        WxaPkgWrappingInfo sZ = f.sZ(oVar);
                        if (sZ == null) {
                            x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, no local available pkg, force update");
                            z = true;
                        } else if (this.jyp <= 0 || this.jyp <= sZ.iGL) {
                            x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], no need force update", new Object[]{Integer.valueOf(sZ.iGL)});
                        } else {
                            x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], preferred version[%d], force update", new Object[]{Integer.valueOf(sZ.iGL), Integer.valueOf(this.jyp)});
                            z = true;
                        }
                    }
                } else {
                    x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, preferVersion[%d], localVersion[%d], forceSync", new Object[]{Integer.valueOf(this.jyp), Integer.valueOf(a.field_version)});
                    z = true;
                }
                z2 = z;
            }
            z = false;
            z2 = z;
        }
        long Wp = bh.Wp();
        if (bh.ov(this.appId)) {
            P = r.P(this.username, z2);
        } else {
            P = r.O(this.appId, z2);
        }
        if (P.first == null) {
            int i = j.iAU;
            Object[] objArr = new Object[1];
            if (P.second == null) {
                oVar = "";
            } else {
                oVar = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((a) P.second).errType), Integer.valueOf(((a) P.second).errCode)});
            }
            objArr[0] = oVar;
            y.ta(y.getMMString(i, objArr));
            com.tencent.mm.plugin.appbrand.report.a.z("", 7, this.iKd + 1);
        } else {
            long Wp2 = bh.Wp() - Wp;
            if (P.second != null) {
                s.a(s.a.jya, this.appId, ((WxaAttributes) P.first).acb().fIm, this.iKd, this.jxz, Wp2);
            }
        }
        if (!z2) {
            Object obj = P.first;
        }
        if (z2 && P.second != null && ((a) P.second).errType == 2) {
            i = j.iAU;
            objArr = new Object[1];
            objArr[0] = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((a) P.second).errType), Integer.valueOf(((a) P.second).errCode)});
            y.ta(y.getMMString(i, objArr));
            return Pair.create(null, Boolean.valueOf(true));
        }
        obj = P.first;
        if (P.second == null) {
            z3 = false;
        }
        return Pair.create(obj, Boolean.valueOf(z3));
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
    }
}
