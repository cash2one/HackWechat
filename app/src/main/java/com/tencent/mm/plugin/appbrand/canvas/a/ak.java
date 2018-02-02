package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class ak implements d {
    public final String getMethod() {
        return "translate";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        canvas.translate(com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 0), com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 1));
        return true;
    }
}
