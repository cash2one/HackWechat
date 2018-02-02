package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class z extends i {
    public JSONObject orF;
    public String sIN = "";

    public z(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        this.sIN = str;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("req_key", str5);
        hashMap.put("transaction_id", str6);
        hashMap.put("activity_mch_id", String.valueOf(j));
        D(hashMap);
    }

    public final int ayQ() {
        return 1979;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/querypayaward";
    }

    public final int Hr() {
        return 1979;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpayQueryPayaward", "errcode %s errmsg %s json %s", new Object[]{Integer.valueOf(i), str, jSONObject});
        this.orF = jSONObject;
    }

    public final boolean bhd() {
        return false;
    }
}
