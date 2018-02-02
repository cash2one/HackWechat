package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i {
    public d(String str, String str2, String str3, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        D(hashMap);
    }

    public d(String str, String str2, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("expired_flag", "1");
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        D(hashMap);
    }

    public final int ayQ() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int Hr() {
        return 473;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbind";
    }
}
