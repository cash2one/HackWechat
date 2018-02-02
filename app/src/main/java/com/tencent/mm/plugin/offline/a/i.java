package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends com.tencent.mm.wallet_core.tenpay.model.i {
    public String fAf = "";
    private String oWA = "0";
    private boolean oWB = false;
    public String oWz = "0";

    public i(Bankcard bankcard, String str, String str2, int i, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("oper", str2);
        if (str2.equals("changeto")) {
            if (TextUtils.isEmpty(str3)) {
                hashMap.put("verify_code", "");
            } else {
                hashMap.put("verify_code", str3);
            }
            hashMap.put("chg_fee", String.valueOf(i));
            hashMap.put("bind_serialno", bankcard.field_bindSerial);
            hashMap.put("bank_type", bankcard.field_bankcardType);
            hashMap.put("card_tail", bankcard.field_bankcardTail);
        }
        this.fAf = bankcard.field_mobile;
        D(hashMap);
    }

    public final int ayQ() {
        return 50;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.oWz = jSONObject.optString("verify_flag");
            this.oWA = jSONObject.optString("limit_fee");
        }
    }
}
