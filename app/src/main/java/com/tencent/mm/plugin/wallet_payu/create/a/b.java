package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fIA;
    public String fzP;
    public String pin;
    public String tbV;

    public final int bKL() {
        return 17;
    }

    public b(String str, String str2, String str3, String str4) {
        this.tbV = str;
        this.fIA = str2;
        this.pin = str3;
        this.fzP = str4;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("payu_reference", str4);
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
