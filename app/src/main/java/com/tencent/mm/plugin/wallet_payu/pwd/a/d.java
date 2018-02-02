package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String fzP;
    public String tdl;
    public String tdm;

    public d(String str, String str2) {
        this.tdl = str;
        this.tdm = str2;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        D(hashMap);
    }

    public final int bKL() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fzP = jSONObject.optString("payu_reference");
    }
}
