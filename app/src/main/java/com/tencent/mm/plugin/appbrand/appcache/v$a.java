package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.v.c;
import java.io.InputStream;

final class v$a implements c {
    static final v$a iEQ = new v$a();
    final WxaPkgWrappingInfo iEP;

    public final InputStream openRead(String str) {
        return y.openRead(str);
    }

    public final WxaPkgWrappingInfo ZR() {
        return this.iEP;
    }

    v$a() {
        this.iEP = new WxaPkgWrappingInfo();
        this.iEP.iGN = true;
        this.iEP.iGK = 0;
        this.iEP.iGL = y.VERSION;
        this.iEP.fqR = "";
    }

    public final String toString() {
        return "AssetReader";
    }
}
