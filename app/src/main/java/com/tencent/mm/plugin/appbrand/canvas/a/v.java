package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

public final class v implements d {
    public final String getMethod() {
        return "setGlobalAlpha";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        boolean z = false;
        try {
            int i = jSONArray.getInt(0);
            fVar.iKO.S(((float) i) / 255.0f);
            fVar.iKP.S(((float) i) / 255.0f);
            return true;
        } catch (JSONException e) {
            x.e("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[]{e});
            return z;
        }
    }
}
