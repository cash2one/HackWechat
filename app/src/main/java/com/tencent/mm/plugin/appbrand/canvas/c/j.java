package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;

public final class j implements a {
    public final String getMethod() {
        return "rect";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 4) {
            return false;
        }
        float d = f.d(jSONArray, 0);
        float d2 = f.d(jSONArray, 1);
        Path path2 = path;
        path2.addRect(d, d2, d + f.d(jSONArray, 2), f.d(jSONArray, 3) + d2, Direction.CW);
        return true;
    }
}
