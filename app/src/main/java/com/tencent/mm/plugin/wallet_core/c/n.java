package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends i {
    public String kZo;
    public Promotions sIB;
    public String sIy;
    public String sIz;

    public n(Promotions promotions, String str, String str2, long j) {
        this.sIB = promotions;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", promotions.sIr);
        hashMap.put("award_id", promotions.sOC);
        hashMap.put("send_record_id", promotions.sNu);
        hashMap.put("user_record_id", promotions.sNv);
        hashMap.put("req_key", str);
        hashMap.put("transaction_id", str2);
        hashMap.put("activity_mch_id", String.valueOf(j));
        D(hashMap);
    }

    public final int ayQ() {
        return 1589;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSenceTenPayBase", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", new Object[]{Integer.valueOf(i), str, jSONObject});
        if (jSONObject != null && i == 0) {
            this.sIy = jSONObject.optString("result_code");
            this.kZo = jSONObject.optString("result_msg");
            this.sIz = jSONObject.optString("alert_wording");
        }
    }

    public final int Hr() {
        return 1589;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendpayaward";
    }
}
