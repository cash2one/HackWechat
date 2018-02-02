package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class ah implements d {
    public final String getMethod() {
        return "setTextBaseline";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        x.i("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[]{optString});
        if ("top".equalsIgnoreCase(optString)) {
            fVar.iKO.iLb = a.iLg;
            fVar.iKP.iLb = a.iLg;
        } else if ("middle".equalsIgnoreCase(optString)) {
            fVar.iKO.iLb = a.iLi;
            fVar.iKP.iLb = a.iLi;
        } else if ("bottom".equalsIgnoreCase(optString)) {
            fVar.iKO.iLb = a.iLh;
            fVar.iKP.iLb = a.iLh;
        } else if ("normal".equalsIgnoreCase(optString)) {
            fVar.iKO.iLb = a.iLf;
            fVar.iKP.iLb = a.iLf;
        }
        return true;
    }
}
