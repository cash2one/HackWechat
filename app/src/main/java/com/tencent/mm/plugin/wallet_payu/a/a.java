package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fzP;
    public boolean qjU;
    public String tcr;
    public String tcs;

    public a(String str, String str2) {
        this.tcr = str;
        this.fzP = str2;
        Map hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", str2);
        D(hashMap);
    }

    public final int bKL() {
        return 4;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.qjU = jSONObject.optBoolean("verified");
        this.tcs = jSONObject.optString("payu_reference");
    }
}
