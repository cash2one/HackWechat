package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.c.e.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class g implements d {
    public final String getMethod() {
        return "strokePath";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        canvas.drawPath(a.iLl.d(jSONArray), fVar.iKO);
        return true;
    }
}
