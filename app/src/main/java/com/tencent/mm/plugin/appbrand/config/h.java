package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.bh;

public final class h {
    public static boolean qH(String str) {
        if (bh.ov(str)) {
            return false;
        }
        AppBrandSysConfig oS = a.oS(str);
        if (oS == null || oS.iNV || oS.iOI.iGK == 0) {
            return false;
        }
        return true;
    }
}
