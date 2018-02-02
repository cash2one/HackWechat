package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ad$a;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class q extends p {
    public final String appId;
    public final int fvM = 0;
    public final String iEF;
    public final int jxW;

    q(String str, String str2, int i) {
        super(new o(str, str2));
        this.appId = str;
        this.iEF = str2;
        this.jxW = i;
    }

    public final String ahX() {
        return String.format(Locale.US, "pkg %s, targetVersion %d, pkgType %d", new Object[]{this.jxU.toString(), Integer.valueOf(this.jxW), Integer.valueOf(0)});
    }

    public final void prepare() {
        Pair p = ad.p(this.jxU.toString(), 0, this.jxW);
        if (p.second != null) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[]{ahX()});
            d((WxaPkgWrappingInfo) p.second);
        } else if (ad$a.APP_BROKEN.equals(p.first)) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[]{ahX()});
            aim com_tencent_mm_protocal_c_aim = new aim();
            com_tencent_mm_protocal_c_aim.fFm = this.appId;
            com_tencent_mm_protocal_c_aim.vOv = this.jxW;
            com_tencent_mm_protocal_c_aim.wpK = 0;
            if (!bh.ov(this.iEF)) {
                com_tencent_mm_protocal_c_aim.wnX = this.iEF;
                com_tencent_mm_protocal_c_aim.wpK = 4;
            }
            com_tencent_mm_protocal_c_aim.wpJ = f.Zo().a(this.jxU.toString(), 0, new String[]{"versionMd5"}).field_versionMd5;
            if (h.ZG() && a.jv(0)) {
                WxaPkgWrappingInfo sZ = f.sZ(this.jxU.toString());
                if (sZ != null) {
                    com_tencent_mm_protocal_c_aim.wpL = sZ.iGL;
                }
            }
            new b(com_tencent_mm_protocal_c_aim).JV().f(new 1(this, com_tencent_mm_protocal_c_aim));
        } else {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, local check failed ret=%s", new Object[]{ahX(), p.first});
            d(null);
        }
    }
}
