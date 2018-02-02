package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$1 implements JsApiAppBrandNFCBase$a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ b joN;

    b$1(b bVar, j jVar, int i) {
        this.joN = bVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void K(int i, String str) {
        x.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            this.iZy.E(this.gOK, this.joN.e("ok", hashMap));
        } else {
            this.iZy.E(this.gOK, this.joN.e("fail " + str, hashMap));
        }
    }
}
