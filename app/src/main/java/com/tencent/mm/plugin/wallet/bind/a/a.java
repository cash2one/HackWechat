package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public int sBK;
    public String sBL;

    public a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bankcard_type", str);
        hashMap.put("bind_serial", str2);
        D(hashMap);
    }

    public final int ayQ() {
        return 1540;
    }

    public final int Hr() {
        return 1540;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbindbanner";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i != 0) {
            return;
        }
        if (jSONObject != null) {
            this.sBK = jSONObject.optInt("unbindbannerlevel", 0);
            this.sBL = jSONObject.optString("unbindbannerwording");
            return;
        }
        x.e("MicroMsg.NetSceneGetUnbindInfo", "json is null");
    }
}
