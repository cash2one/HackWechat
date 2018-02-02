package c.t.m.g;

import org.json.JSONException;
import org.json.JSONObject;

public final class dv {
    public double a;
    public double b;
    public double c;
    public float d;
    public String e;
    public String f;

    dv() {
    }

    public dv(JSONObject jSONObject) {
        try {
            this.a = jSONObject.getDouble("latitude");
            this.b = jSONObject.getDouble("longitude");
            this.c = jSONObject.getDouble("altitude");
            this.d = (float) jSONObject.getDouble("accuracy");
            this.e = jSONObject.optString("name");
            this.f = jSONObject.optString("addr");
        } catch (JSONException e) {
            throw e;
        }
    }
}
