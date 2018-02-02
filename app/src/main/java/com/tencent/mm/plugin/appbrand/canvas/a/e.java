package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class e implements d {
    public final String getMethod() {
        return "arc";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 5) {
            return false;
        }
        float d = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 0);
        float d2 = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 1);
        float d3 = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 2);
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF(d - d3, d2 - d3, d + d3, d3 + d2), (float) ((((double) ((float) jSONArray.optDouble(3))) / 3.141592653589793d) * 180.0d), (float) ((((double) ((float) jSONArray.optDouble(4))) / 3.141592653589793d) * 180.0d), true, fVar.iKO);
        return true;
    }
}
