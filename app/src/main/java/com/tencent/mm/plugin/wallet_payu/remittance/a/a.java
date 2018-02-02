package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fGJ;
    public String fpP;
    public String fuH;
    public double pNX;
    public String pin;
    public String sBM;
    public int tbr;
    public int tdp;
    public double tdq;
    public String tdr;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        this.fuH = str;
        this.pin = str2;
        this.pNX = d;
        this.fpP = str3;
        this.tdp = i == 2 ? 0 : i;
        this.fGJ = str4;
        this.sBM = str5;
        Map hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        D(hashMap);
    }

    public final int bKL() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.tbr = jSONObject.optInt("response_result");
        this.tdq = bh.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.tdr = jSONObject.optString("fee_type");
    }
}
