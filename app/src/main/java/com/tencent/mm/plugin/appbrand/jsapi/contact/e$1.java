package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

class e$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ e jja;

    e$1(e eVar, j jVar, JSONObject jSONObject, int i) {
        this.jja = eVar;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 48) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.iZy.E(this.gOK, this.jja.e("fail:system permission denied", null));
            } else {
                this.jja.a(this.iZy, this.jel, this.gOK);
            }
        }
    }
}
