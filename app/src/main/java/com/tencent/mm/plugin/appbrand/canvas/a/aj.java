package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;
import org.json.JSONException;

public final class aj implements d {
    public final String getMethod() {
        return "transform";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        try {
            float f = (float) jSONArray.getDouble(0);
            float f2 = (float) jSONArray.getDouble(1);
            float f3 = (float) jSONArray.getDouble(2);
            float f4 = (float) jSONArray.getDouble(3);
            float c = com.tencent.mm.plugin.appbrand.p.f.c(jSONArray, 4);
            float c2 = com.tencent.mm.plugin.appbrand.p.f.c(jSONArray, 5);
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.preSkew(f3, f2);
            matrix.preTranslate(c, c2);
            matrix.preScale(f, f4);
            canvas.concat(matrix);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
