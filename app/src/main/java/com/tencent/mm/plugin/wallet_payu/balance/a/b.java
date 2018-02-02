package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fpP;
    public String fuH;
    public boolean isRedirect;
    public String lie;
    public double pNX;
    public String pin;
    public String tbn;
    public String tbo;
    public String tbp;
    public String tbq;
    public int tbr;
    public String tbs;
    public String tbt;
    public boolean tbu;
    public String tbv;

    public b(String str, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.pin = str;
        this.tbn = str2;
        this.fuH = str3;
        this.pNX = d;
        this.fpP = str4;
        this.tbo = str5;
        this.tbp = str6;
        this.tbq = str7;
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        D(hashMap);
    }

    public final int bKL() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.lie = jSONObject.optString("trans_id");
        this.tbr = jSONObject.optInt("response_result");
        this.isRedirect = jSONObject.optBoolean("redirect");
        this.tbs = jSONObject.optString("gateway_reference");
        this.tbt = jSONObject.optString("gateway_code");
        this.tbu = jSONObject.optBoolean("is_force_adjust");
        this.tbv = jSONObject.optString("force_adjust_code");
    }
}
