package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

class b$2 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ b jiH;

    b$2(b bVar, j jVar, JSONObject jSONObject, int i) {
        this.jiH = bVar;
        this.iZy = jVar;
        this.jel = jSONObject;
        this.gOK = i;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 48) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                this.iZy.E(this.gOK, this.jiH.e("permission_denied", null));
            } else {
                this.jiH.a(this.iZy, this.jel, this.gOK);
            }
        }
    }
}
