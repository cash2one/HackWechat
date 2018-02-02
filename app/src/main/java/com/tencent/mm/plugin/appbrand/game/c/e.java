package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.ak;

public final class e {
    String appId;
    int fIm;
    int fno;
    public int iYL;
    int iYM;
    int iYN;
    public ak ikI;

    public e(String str, int i) {
        this.iYL = Math.max(1, i);
        this.appId = str;
        com.tencent.mm.plugin.appbrand.e oQ = a.oQ(str);
        if (oQ != null && oQ.iqx != null) {
            this.fIm = oQ.iqx.iOI.iGL;
            this.fno = oQ.iqx.iOI.iGK + 1;
        }
    }
}
