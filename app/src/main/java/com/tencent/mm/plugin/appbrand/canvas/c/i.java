package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;

public final class i implements a {
    public final String getMethod() {
        return "quadraticCurveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        path.quadTo(f.d(jSONArray, 0), f.d(jSONArray, 1), f.d(jSONArray, 2), f.d(jSONArray, 3));
        return true;
    }
}
