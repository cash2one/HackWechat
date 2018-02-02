package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.sdk.platformtools.bh;

final class ad {
    static String aF(String str, int i) {
        ae a = f.Zo().a(str, i, new String[]{"versionMd5", "pkgPath"});
        if (a == null || bh.ov(a.field_pkgPath) || !e.bO(a.field_pkgPath) || bh.ov(a.field_versionMd5) || !a.field_pkgPath.equals(g.bV(a.field_pkgPath))) {
            return null;
        }
        return a.field_versionMd5;
    }
}
