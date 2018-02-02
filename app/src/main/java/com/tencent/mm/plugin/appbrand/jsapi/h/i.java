package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.picker.g;
import org.json.JSONObject;

final class i extends c {
    int jpJ = -1;
    int jpK = -1;
    int jpL = Integer.MAX_VALUE;
    int jpM = Integer.MAX_VALUE;
    int jpN = -1;
    int jpO = -1;

    i() {
    }

    final void r(JSONObject jSONObject) {
        int[] vf;
        JSONObject optJSONObject = jSONObject.optJSONObject("range");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] vf2 = g.vf(optString);
            if (vf2 != null) {
                this.jpJ = vf2[0];
                this.jpK = vf2[1];
            }
            vf = g.vf(optString2);
            if (vf != null) {
                this.jpL = vf[0];
                this.jpM = vf[1];
            }
        }
        this.jpJ = Math.max(this.jpJ, 0);
        this.jpK = Math.max(this.jpK, 0);
        this.jpL = Math.min(this.jpL, 23);
        this.jpM = Math.min(this.jpM, 59);
        vf = g.vf(jSONObject.optString("current"));
        if (vf != null) {
            this.jpN = vf[0];
            this.jpO = vf[1];
        }
        c.runOnUiThread(new 1(this));
    }
}
