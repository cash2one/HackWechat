package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    public static void a(View view, JSONObject jSONObject) {
        if (view != null && jSONObject != null) {
            int i;
            int uA = f.uA(jSONObject.optString("bgColor"));
            int uA2 = f.uA(jSONObject.optString("borderColor"));
            float a = f.a(jSONObject, "borderRadius", 0.0f);
            float a2 = f.a(jSONObject, "borderWidth", 0.0f);
            if (view instanceof e) {
                e eVar = (e) view;
                eVar.kw(uA);
                eVar.kv(uA2);
                eVar.V(a);
                eVar.W(a2);
                i = 1;
            } else {
                i = 0;
            }
            try {
                float f = (float) jSONObject.getDouble("opacity");
                if (f >= 0.0f && f <= 1.0f) {
                    view.setAlpha(f);
                    i = 1;
                }
            } catch (JSONException e) {
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                view.setPadding(f.a(optJSONArray, 3), f.a(optJSONArray, 0), f.a(optJSONArray, 1), f.a(optJSONArray, 2));
            }
            if (i != 0) {
                view.invalidate();
            }
        }
    }
}
