package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class ag implements d {
    public final String getMethod() {
        return "setTextAlign";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() <= 0) {
            return false;
        }
        String optString = jSONArray.optString(0);
        if ("left".equalsIgnoreCase(optString)) {
            fVar.iKO.setTextAlign(Align.LEFT);
            fVar.iKP.setTextAlign(Align.LEFT);
        } else if ("right".equalsIgnoreCase(optString)) {
            fVar.iKO.setTextAlign(Align.RIGHT);
            fVar.iKP.setTextAlign(Align.RIGHT);
        } else if ("center".equalsIgnoreCase(optString)) {
            fVar.iKO.setTextAlign(Align.CENTER);
            fVar.iKP.setTextAlign(Align.CENTER);
        }
        return true;
    }
}
