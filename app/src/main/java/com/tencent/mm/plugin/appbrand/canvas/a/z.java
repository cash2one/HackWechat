package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public final class z implements d {
    public final String getMethod() {
        return "setLineHeight";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() != 0) {
            try {
                com.tencent.mm.plugin.appbrand.p.f.j(jSONArray);
            } catch (JSONException e) {
                x.i("MicroMsg.SetLineHeight", "get 'lineHeight' error");
            }
        }
        return false;
    }
}
