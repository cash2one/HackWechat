package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m extends i {
    public String kZo;
    public BindCardOrder sIA;
    public String sIy;
    public String sIz;

    public m(BindCardOrder bindCardOrder, String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, int i, int i2) {
        this.sIA = bindCardOrder;
        Map hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("activity_mch_id", String.valueOf(j));
        hashMap.put("activity_type", String.valueOf(j2));
        hashMap.put("bank_type", str5);
        hashMap.put("bank_serial", str6);
        hashMap.put("bindbankscene", String.valueOf(i));
        hashMap.put("realname_scene", String.valueOf(i2));
        D(hashMap);
    }

    public final int ayQ() {
        return 1786;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.sIy = jSONObject.optString("result_code");
            this.kZo = jSONObject.optString("result_msg");
            this.sIz = jSONObject.optString("alert_wording");
        }
    }

    public final int Hr() {
        return 1786;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendbindcardaward";
    }
}
