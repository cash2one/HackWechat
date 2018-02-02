package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public int cRJ;
    public String fuH;
    public String lie;
    public String pin;
    public String sBM;
    public String sQZ;
    public String tbn;
    public String tbs;
    public String tbt;
    public String tbv;
    public double tcK;
    public String tcL;
    public double tcM;
    public String tcN;
    public boolean tcO;
    public boolean tcP;
    public String tcQ;
    public String tcR;
    public String tcS;

    public b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        this.fuH = str;
        this.tcK = d;
        this.tcL = str2;
        this.sQZ = str3;
        this.sBM = str4;
        this.tbn = str5;
        this.pin = str6;
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", str3);
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", str5);
        }
        hashMap.put("pin", str6);
        D(hashMap);
    }

    public final int bKL() {
        return 9;
    }

    public final boolean isSuccess() {
        return this.tcQ.equals("1");
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lie = jSONObject.optString("trans_id");
            this.tcM = jSONObject.optDouble("total_fee") / 100.0d;
            this.tcN = jSONObject.optString("fee_type");
            this.tcO = jSONObject.optBoolean("redirect");
            this.tbs = jSONObject.optString("gateway_reference");
            this.tbt = jSONObject.optString("gateway_code");
            this.tcQ = jSONObject.optString("pay_status");
            this.cRJ = jSONObject.optInt("timestamp");
            this.tcR = jSONObject.optString("pay_status_name");
            this.tcS = jSONObject.optString("bank_type");
            this.tcP = jSONObject.optBoolean("is_force_adjust");
            this.tbv = jSONObject.optString("force_adjust_code");
        }
    }
}
