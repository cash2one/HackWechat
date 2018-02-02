package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONException;

public final class r implements d {
    public final String getMethod() {
        return "setFontFamily";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return false;
        }
        try {
            String string = jSONArray.getString(0);
            fVar.iKO.qg(string);
            fVar.iKP.qg(string);
            return true;
        } catch (JSONException e) {
            x.i("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
            return false;
        }
    }
}
