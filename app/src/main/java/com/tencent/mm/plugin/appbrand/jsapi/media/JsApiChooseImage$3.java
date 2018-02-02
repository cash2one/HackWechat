package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

class JsApiChooseImage$3 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ JsApiChooseImage jmF;

    JsApiChooseImage$3(JsApiChooseImage jsApiChooseImage, j jVar, JSONObject jSONObject, int i) {
        this.jmF = jsApiChooseImage;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 113) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.iZy.E(this.gOK, this.jmF.e("fail:system permission denied", null));
            } else {
                this.jmF.a(this.iZy, this.jel, this.gOK);
            }
        }
    }
}
