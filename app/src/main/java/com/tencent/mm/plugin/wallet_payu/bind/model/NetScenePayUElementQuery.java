package com.tencent.mm.plugin.wallet_payu.bind.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String tbx;
    public PayUBankcardElement tbz;

    public NetScenePayUElementQuery(String str) {
        this.tbx = str;
        Map hashMap = new HashMap();
        hashMap.put("card_number", str);
        D(hashMap);
    }

    public final int bKL() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.tbz = new PayUBankcardElement();
        this.tbz.tbA = jSONObject.optString("bin");
        this.tbz.pax = jSONObject.optString("bank_name");
        this.tbz.tbB = jSONObject.optString("issuer_type");
        this.tbz.cardType = jSONObject.optString("card_type");
        this.tbz.fzP = jSONObject.optString("payu_reference");
    }
}
