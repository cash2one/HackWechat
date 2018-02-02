package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public f(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        D(hashMap);
    }

    public final int ayQ() {
        return 62;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
