package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.plugin.nfc.b.c;
import java.util.HashMap;
import java.util.Map;

class d$1 implements a {
    final /* synthetic */ d joR;

    d$1(d dVar) {
        this.joR = dVar;
    }

    public final void K(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            e eVar = this.joR;
            eVar.iqt = eVar.a(eVar.iqB);
            if (eVar.iqt == null) {
                eVar.sj(eVar.e("fail: unknown error", null));
                return;
            }
            Intent intent = new Intent();
            eVar.iqt.jwN = new d$2(eVar);
            d.b(eVar.iqt, "nfc", "com.tencent.mm.plugin.hce.ui.HCETransparentUI", intent, 1);
            return;
        }
        c.N(this.joR.iqB.mAppId, i, -1);
        this.joR.sj(this.joR.e("fail: " + str, hashMap));
    }
}
