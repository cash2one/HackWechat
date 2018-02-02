package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends i {
    public String fCU = null;

    public g(String str, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str5);
        aB(hashMap);
    }

    public final int ayQ() {
        return 65;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fCU = jSONObject.optString("app_username");
        }
    }
}
