package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends i {
    public j(String str) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.yF());
        D(hashMap);
    }

    public final int ayQ() {
        return 47;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
    }

    public final int Hr() {
        return 566;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
    }
}
