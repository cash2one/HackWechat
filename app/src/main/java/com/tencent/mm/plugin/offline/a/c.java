package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public c(String str, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("pay_scene", String.valueOf(i));
        hashMap.put("pay_channel", String.valueOf(i2));
        D(hashMap);
    }

    public final int ayQ() {
        return 1385;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), str});
    }
}
