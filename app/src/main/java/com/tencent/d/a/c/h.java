package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private long Acp = -1;
    private String Acq = "";
    public String Acr = "";
    public String rSm = "";
    public String signature = "";
    public int uid = -1;

    public final String toString() {
        return "SoterPubKeyModel{counter=" + this.Acp + ", uid=" + this.uid + ", cpu_id='" + this.rSm + '\'' + ", pub_key_in_x509='" + this.Acq + '\'' + ", rawJson='" + this.Acr + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public h(String str, String str2) {
        this.Acr = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.Acp = jSONObject.optLong("counter");
            this.uid = jSONObject.optInt("uid");
            this.rSm = jSONObject.optString("cpu_id");
            this.Acq = jSONObject.optString("pub_key");
        } catch (JSONException e) {
            c.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
    }
}
