package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class aq$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ aq jdz;

    aq$1(aq aqVar, j jVar, int i) {
        this.jdz = aqVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        aq.ID();
        if (i == (this.jdz.hashCode() & 65535)) {
            x.i("MicroMsg.JsApiOpenQRCode", "onActivityResult requestCode:%d  resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            switch (i2) {
                case -1:
                    if (intent == null) {
                        x.e("MicroMsg.JsApiOpenQRCode", "data is null, err");
                        this.iZy.E(this.gOK, this.jdz.e("fail:unknown err", null));
                        return;
                    }
                    Map hashMap = new HashMap();
                    x.d("MicroMsg.JsApiOpenQRCode", "result:%s, resultType:%d", intent.getStringExtra("key_scan_result"), Integer.valueOf(intent.getIntExtra("key_scan_result_type", 0)));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("scan_type", intent.getIntExtra("key_scan_result_type", 0) == 1 ? "qrcode" : "barcode");
                        jSONObject.put("scan_result", r2);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e, "", new Object[0]);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("scan_code", jSONObject);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiOpenQRCode", e2, "", new Object[0]);
                    }
                    hashMap.put("resultStr", jSONObject2.toString());
                    x.d("MicroMsg.JsApiOpenQRCode", "ret:%s", hashMap);
                    this.iZy.E(this.gOK, this.jdz.e("ok", hashMap));
                    return;
                case 0:
                    this.iZy.E(this.gOK, this.jdz.e("cancel", null));
                    return;
                default:
                    this.iZy.E(this.gOK, this.jdz.e("fail", null));
                    return;
            }
        }
    }
}
