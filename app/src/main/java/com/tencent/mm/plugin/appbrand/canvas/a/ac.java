package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class ac implements d {
    public final String getMethod() {
        return "setMiterLimit";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        float optDouble = (float) jSONArray.optDouble(0);
        fVar.iKP.setStrokeMiter(optDouble);
        fVar.iKO.setStrokeMiter(optDouble);
        return true;
    }
}
