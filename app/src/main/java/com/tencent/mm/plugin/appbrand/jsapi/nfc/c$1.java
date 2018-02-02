package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class c$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject joO;
    final /* synthetic */ c joP;

    c$1(c cVar, j jVar, int i, JSONObject jSONObject) {
        this.joP = cVar;
        this.iZy = jVar;
        this.gOK = i;
        this.joO = jSONObject;
    }

    public final void K(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i));
        if (i == 0) {
            c cVar = this.joP;
            j jVar = this.iZy;
            int i2 = this.gOK;
            JSONObject jSONObject = this.joO;
            Map hashMap2 = new HashMap();
            String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
            if (bh.ov(optString)) {
                hashMap2.put("errCode", Integer.valueOf(13005));
                c.a(jVar, i2, cVar.e("fail", hashMap2));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", optString);
            HCEEventLogic.c(jVar.mAppId, 32, bundle);
            hashMap2.put("errCode", Integer.valueOf(0));
            jVar.E(i2, cVar.e("ok", hashMap2));
            return;
        }
        c.a(this.iZy, this.gOK, this.joP.e("fail: " + str, hashMap));
    }
}
