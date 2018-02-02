package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.p.f;
import org.json.JSONException;
import org.json.JSONObject;

public class c$f {
    public int id;
    public float x;
    public float y;

    public c$f(int i, float f, float f2) {
        this.id = i;
        this.x = f;
        this.y = f2;
    }

    public final void a(int i, float f, float f2) {
        this.id = i;
        this.x = f;
        this.y = f2;
    }

    public final JSONObject sN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, this.id);
            jSONObject.put("x", (double) f.ab(this.x));
            jSONObject.put("y", (double) f.ab(this.y));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return sN().toString();
    }
}
