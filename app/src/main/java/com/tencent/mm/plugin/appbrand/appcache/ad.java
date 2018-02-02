package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.y.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public enum ad {
    ;

    public static Pair<a, WxaPkgWrappingInfo> cr(boolean z) {
        return l(z, false);
    }

    public static Pair<a, WxaPkgWrappingInfo> l(boolean z, boolean z2) {
        if (z && !(z2 && y.iFd == a.iFh)) {
            com.tencent.mm.plugin.appbrand.a.a aVar = (com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class);
            if (aVar != null) {
                ai YW = aVar.YW();
                if (YW != null) {
                    Object obj;
                    int ai = YW.ai("@LibraryAppId", 0);
                    if (!"@LibraryAppId".equals("@LibraryAppId") || (ai >= 0 && y.VERSION < ai)) {
                        obj = null;
                    } else {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[]{Integer.valueOf(y.VERSION), r0, Integer.valueOf(0), Integer.valueOf(ai)});
                        obj = y.ZW();
                    }
                    if (obj != null) {
                        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, dbMax %d, local %d, use local", new Object[]{Integer.valueOf(ai), Integer.valueOf(y.VERSION)});
                        return Pair.create(a.iFU, obj);
                    }
                }
            }
            return Pair.create(a.iFU, y.ZW());
        }
        x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkLibrary, release %b, skipLocalDevPack %b, localPackMode %s, checkRecordResult %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), y.iFd, p("@LibraryAppId", z ? 0 : 999, -1).first});
        return p("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static Pair<a, WxaPkgWrappingInfo> p(String str, int i, int i2) {
        if (((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW() == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return Pair.create(a.iFZ, null);
        }
        ae a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime"};
        if (!d.a.jv(i) || i2 <= 0) {
            a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(str, i, strArr);
        } else {
            a = ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).YW().a(str, i2, i, strArr);
        }
        if (a == null) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return Pair.create(a.iFV, null);
        }
        int i3;
        String str2 = a.field_pkgPath;
        String str3 = a.field_versionMd5;
        if (i2 < 0) {
            i3 = a.field_version;
        } else {
            i3 = i2;
        }
        long j = a.field_createTime;
        if (bh.ov(str2) || !e.bO(str2)) {
            x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i3)});
            return Pair.create(a.iFY, null);
        }
        String bV = com.tencent.mm.a.g.bV(str2);
        if (bh.ov(str3) || str3.equals(bV)) {
            WxaPkgWrappingInfo pO = WxaPkgWrappingInfo.pO(str2);
            if (pO == null) {
                x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                return Pair.create(a.iFY, null);
            }
            pO.iGL = i3;
            pO.iGM = j;
            pO.iEa = str2;
            pO.iGN = false;
            pO.iGK = i;
            pO.fqR = bV;
            x.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), pO});
            return Pair.create(a.iFU, pO);
        }
        x.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[]{bV, str3, str, Integer.valueOf(i), Integer.valueOf(i2)});
        return Pair.create(a.iFY, null);
    }
}
