package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.platformtools.bh;

public final class o {
    private final String appId;
    private final String iEF;
    private volatile String iEG;

    public o(String str, String str2) {
        this.appId = str;
        if (bh.ov(str2) || "__APP__".equals(str2)) {
            this.iEF = str2;
        } else {
            this.iEF = a.py(str2);
        }
    }

    public final String toString() {
        if (bh.ov(this.iEG)) {
            this.iEG = this.appId + (bh.ov(this.iEF) ? "" : "$" + this.iEF);
        }
        return this.iEG;
    }
}
