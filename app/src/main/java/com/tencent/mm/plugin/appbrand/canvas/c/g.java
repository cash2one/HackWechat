package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;

public final class g implements a {
    public final String getMethod() {
        return "lineTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        path.lineTo(f.d(jSONArray, 0), f.d(jSONArray, 1));
        return true;
    }
}
