package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;

public final class c implements a {
    public final String getMethod() {
        return "arcTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        float d = f.d(jSONArray, 0);
        float d2 = f.d(jSONArray, 1);
        float d3 = f.d(jSONArray, 2);
        float f = d - d3;
        float f2 = d2 - d3;
        float f3 = d + d3;
        float f4 = d2 + d3;
        float toDegrees = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(3)));
        d = (float) Math.toDegrees((double) ((float) jSONArray.optDouble(4)));
        d3 = (float) (360.0d / (6.283185307179586d * ((double) d3)));
        if (jSONArray.optBoolean(5)) {
            if (toDegrees - d >= 360.0f) {
                d = -360.0f;
            } else {
                d2 = toDegrees % 360.0f;
                d %= 360.0f;
                if (d2 < 0.0f) {
                    d2 += 360.0f;
                }
                if (d < 0.0f) {
                    d += 360.0f;
                }
                if (d >= d2) {
                    d = (d - d2) - 360.0f;
                } else {
                    d -= d2;
                }
            }
        } else if (d - toDegrees >= 360.0f) {
            d = 360.0f;
        } else {
            d2 = toDegrees % 360.0f;
            d %= 360.0f;
            if (d2 < 0.0f) {
                d2 += 360.0f;
            }
            if (d < 0.0f) {
                d += 360.0f;
            }
            if (d >= d2) {
                d -= d2;
            } else {
                d = (d + 360.0f) - d2;
            }
        }
        d2 = d % 360.0f;
        if (d2 > d3 || d2 < (-d3)) {
            path.arcTo(new RectF(f, f2, f3, f4), toDegrees, d, false);
        } else {
            path.arcTo(new RectF(f, f2, f3, f4), toDegrees, d, false);
            path.addArc(new RectF(f, f2, f3, f4), toDegrees, d);
        }
        return true;
    }
}
