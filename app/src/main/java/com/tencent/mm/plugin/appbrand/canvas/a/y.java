package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;
import org.json.JSONException;

public final class y implements d {
    public final String getMethod() {
        return "setLineDash";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        try {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            if (jSONArray2 == null) {
                return false;
            }
            float[] fArr = new float[jSONArray2.length()];
            for (int i = 0; i < fArr.length; i++) {
                fArr[i] = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray2, i);
            }
            fVar.iKO.setPathEffect(new DashPathEffect(fArr, com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 1)));
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
