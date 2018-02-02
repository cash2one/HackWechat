package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab extends i {
    public String sIC;
    public String sIP;

    public ab(p pVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", pVar.sPk);
        hashMap.put("token", pVar.token);
        hashMap.put("passwd", pVar.sPj);
        hashMap.put("relation_key", str);
        D(hashMap);
    }

    public final int ayQ() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.sIC = jSONObject.optString("token_type");
            this.sIP = jSONObject.optString("usertoken");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int Hr() {
        return 1604;
    }
}
