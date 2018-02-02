package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fzP;
    public String tbV;
    public String tbW;
    public boolean tct;

    public b(String str, String str2) {
        this.tbV = str;
        this.tbW = str2;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        D(hashMap);
    }

    public final int bKL() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", new Object[]{Integer.valueOf(i), str, jSONObject.toString()});
        this.tct = jSONObject.optBoolean("has_mobile");
        this.fzP = jSONObject.optString("payu_reference");
    }
}
