package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import java.util.HashMap;
import java.util.Map;

class e$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ e joS;

    e$1(e eVar, j jVar, int i) {
        this.joS = eVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void K(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            e eVar = this.joS;
            j jVar = this.iZy;
            int i2 = this.gOK;
            HCEEventLogic.sF(jVar.mAppId);
            HCEEventLogic.a(null);
            HCEEventLogic.c(jVar.mAppId, 13, null);
            Map hashMap2 = new HashMap(2);
            hashMap2.put("errCode", Integer.valueOf(0));
            e.a(jVar, i2, eVar.e("ok", hashMap2));
            return;
        }
        e.a(this.iZy, this.gOK, this.joS.e("fail: " + str, hashMap));
    }
}
