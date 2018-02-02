package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aj.a;
import java.util.Locale;

final class x extends ab {
    final int iEZ;
    final int iFa;
    final a iFb;

    static String n(String str, int i, int i2) {
        return String.format(Locale.US, "WxaPkgDiff_%s_%d_%d", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    x(String str, int i, int i2, String str2, a aVar) {
        super(n(str, i, i2), aa.ZZ() + String.format(Locale.US, "_%s_%d_%d.wxapkg.diff", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)}), str2, str, 0, i2);
        this.iEZ = i;
        this.iFa = i2;
        this.iFb = aVar;
        this.iFO = true;
    }

    public final String ZS() {
        return ag(this.appId, this.iFa);
    }
}
