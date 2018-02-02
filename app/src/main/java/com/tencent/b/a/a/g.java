package com.tencent.b.a.a;

import org.json.JSONException;
import org.json.JSONObject;

final class g {
    String bjM = null;
    String bpq = null;
    String bpr = "0";
    long bps = 0;

    g() {
    }

    static g bI(String str) {
        g gVar = new g();
        if (s.bJ(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.bjM = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.bpq = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.bpr = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.bps = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
            }
        }
        return gVar;
    }

    final int a(g gVar) {
        if (gVar == null) {
            return 1;
        }
        if (s.bK(this.bpr) && s.bK(gVar.bpr)) {
            if (this.bpr.equals(gVar.bpr)) {
                return 0;
            }
            if (this.bps < gVar.bps) {
                return -1;
            }
            return 1;
        } else if (s.bK(this.bpr)) {
            return 1;
        } else {
            return -1;
        }
    }

    public final String toString() {
        return sJ().toString();
    }

    private JSONObject sJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.bjM);
            s.a(jSONObject, "mc", this.bpq);
            s.a(jSONObject, "mid", this.bpr);
            jSONObject.put("ts", this.bps);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
