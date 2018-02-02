package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class k implements d {
    public final String getMethod() {
        return "fillRect";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float d = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 0);
        float d2 = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 1);
        Canvas canvas2 = canvas;
        canvas2.drawRect(d, d2, d + com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 2), com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 3) + d2, fVar.iKP);
        return true;
    }
}
