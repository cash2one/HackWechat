package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.plugin.appbrand.j;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    private volatile f jkl;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        synchronized (this) {
            if (this.jkl == null) {
                this.jkl = new f(jVar);
                this.jkl.start();
            }
        }
        boolean optBoolean = jSONObject.optBoolean("enable");
        if (optBoolean || i(jVar)) {
            if (!optBoolean) {
                this.jkl.Dh(2);
            } else if (i(jVar)) {
                this.jkl.Dh(1);
            } else {
                jVar.E(i, e("fail:system permission denied", null));
            }
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("ok", null));
    }
}
