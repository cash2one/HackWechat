package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends i {
    public p(String str) {
        Map hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        D(hashMap);
    }

    public final int ayQ() {
        return 1663;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int Hr() {
        return 1663;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    public final int getType() {
        return super.getType();
    }
}
