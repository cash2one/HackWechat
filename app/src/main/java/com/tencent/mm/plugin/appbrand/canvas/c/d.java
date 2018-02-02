package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;

public final class d implements a {
    public final String getMethod() {
        return "bezierCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        path.cubicTo(f.d(jSONArray, 0), f.d(jSONArray, 1), f.d(jSONArray, 2), f.d(jSONArray, 3), f.d(jSONArray, 4), f.d(jSONArray, 5));
        return true;
    }
}
