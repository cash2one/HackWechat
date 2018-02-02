package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d extends a {
    public int i(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    protected static float[] j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            float a = f.a(jSONObject2, "left", 0.0f);
            float a2 = f.a(jSONObject2, "top", 0.0f);
            float a3 = f.a(jSONObject2, "width", 0.0f);
            float a4 = f.a(jSONObject2, "height", 0.0f);
            int optInt = jSONObject.optInt("zIndex", 0);
            return new float[]{a, a2, a3, a4, (float) optInt};
        } catch (Exception e) {
            return null;
        }
    }

    protected static int k(JSONObject jSONObject) {
        int i = -1;
        try {
            return jSONObject.getBoolean("hide") ? 4 : 0;
        } catch (JSONException e) {
            return i;
        }
    }

    protected static Boolean l(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (JSONException e) {
            return null;
        }
    }
}
