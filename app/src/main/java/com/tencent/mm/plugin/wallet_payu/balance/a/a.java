package com.tencent.mm.plugin.wallet_payu.balance.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fpP;
    public String fuH;
    public double pNX;

    public a(double d, String str) {
        this.pNX = d;
        this.fpP = str;
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        D(hashMap);
    }

    public final int bKL() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fuH = jSONObject.optString("prepayid");
    }
}
