package com.tencent.mm.plugin.wallet_core.model;

import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public double pKP = 0.0d;
    public String sKJ;
    public LinkedList<b> sKK;
    public String sKL;
    public String sKM;
    public a sKN;
    public int szv = 0;
    public int szw = 0;
    public int szx = 0;
    public double szy = 0.0d;

    public static class a {
        public String sKO = "";
        public c[] sKP = new c[0];
    }

    public static a U(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                aVar.sKO = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    aVar.sKP = new c[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        c cVar = new c();
                        cVar.title = jSONObject2.optString("title", "");
                        cVar.desc = jSONObject2.optString("desc", "");
                        cVar.kJP = jSONObject2.optString("logo_url", "");
                        cVar.szZ = jSONObject2.optInt("jump_type");
                        cVar.kLB = jSONObject2.optString("jump_url", "");
                        aVar.sKP[i] = cVar;
                    }
                }
            } catch (JSONException e) {
            }
        }
        return aVar;
    }
}
