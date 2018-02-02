package com.tencent.mm.plugin.appbrand.appcache;

import java.io.InputStream;
import java.util.Locale;

final class v$d implements v$c {
    private final WxaPkgWrappingInfo iEP;
    private final z iES;

    private v$d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.iEP = wxaPkgWrappingInfo;
        this.iES = new z(wxaPkgWrappingInfo.iEa);
    }

    public final InputStream openRead(String str) {
        this.iES.ZX();
        return this.iES.pI(str);
    }

    public final WxaPkgWrappingInfo ZR() {
        return this.iEP;
    }

    public final String toString() {
        return String.format(Locale.US, "PkgReader[%d]", new Object[]{Integer.valueOf(this.iEP.iGL)});
    }
}
