package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

class JsApiChooseVideo$3 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ JsApiChooseVideo jnq;

    JsApiChooseVideo$3(JsApiChooseVideo jsApiChooseVideo, j jVar, JSONObject jSONObject, int i) {
        this.jnq = jsApiChooseVideo;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 115) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.iZy.E(this.gOK, this.jnq.e("fail:system permission denied", null));
            } else {
                this.jnq.a(this.iZy, this.jel, this.gOK);
            }
        }
    }
}
