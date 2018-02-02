package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiOperateRecorder$3 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ JsApiOperateRecorder jfi;

    JsApiOperateRecorder$3(JsApiOperateRecorder jsApiOperateRecorder, j jVar, JSONObject jSONObject, int i) {
        this.jfi = jsApiOperateRecorder;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 116) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                this.iZy.E(this.gOK, this.jfi.e("fail:system permission denied", null));
                return;
            }
            x.i("MicroMsg.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
            this.jfi.a(this.iZy, this.jel, this.gOK);
        }
    }
}
