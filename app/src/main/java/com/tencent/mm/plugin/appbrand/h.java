package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.WeakHashMap;

public class h {
    private static final WeakHashMap<e, h> irD = new WeakHashMap();
    private static final h irE = new 1();
    private final e irF;
    public volatile String irG;

    public static h e(e eVar) {
        if (eVar == null || bh.ov(eVar.mAppId)) {
            return irE;
        }
        h hVar;
        synchronized (irD) {
            hVar = (h) irD.get(eVar);
            if (hVar == null) {
                hVar = new h(eVar);
                irD.put(eVar, hVar);
            }
        }
        return hVar;
    }

    public static h ph(String str) {
        if (bh.ov(str)) {
            return irE;
        }
        return e(a.oQ(str));
    }

    private h(e eVar) {
        this.irG = "";
        this.irF = eVar;
    }

    public AppBrandLaunchReferrer YL() {
        return this.irF.iqw.iNZ;
    }
}
