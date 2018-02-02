package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class c$7 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ p jdJ;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ c jlc;
    final /* synthetic */ Activity oZ;

    c$7(c cVar, Activity activity, p pVar, JSONObject jSONObject, int i) {
        this.jlc = cVar;
        this.oZ = activity;
        this.jdJ = pVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", new Object[]{Integer.valueOf(i)});
        if (i == 117) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                this.jdJ.E(this.gOK, this.jlc.e("fail:system permission denied", null));
                return;
            }
            ag.h(new 1(this), 50);
        } else if (i != 118) {
        } else {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                x.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                this.jdJ.E(this.gOK, this.jlc.e("fail:system permission denied", null));
                return;
            }
            ag.h(new 2(this), 50);
        }
    }
}
