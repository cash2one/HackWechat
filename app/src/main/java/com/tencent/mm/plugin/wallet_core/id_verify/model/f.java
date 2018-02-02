package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    public String sJX;
    public String sJY;
    public String sJZ;
    public String sKa;
    public String sKb;

    public f(String str) {
        Map hashMap = new HashMap();
        hashMap.put("channel", "1");
        D(hashMap);
        this.sKb = str;
    }

    public final int ayQ() {
        return 1630;
    }

    public final int Hr() {
        return 1630;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnameguidequery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0 && jSONObject != null) {
            this.sJX = jSONObject.optString("guide_flag");
            this.sJY = jSONObject.optString("guide_wording");
            this.sJZ = jSONObject.optString("left_button_wording");
            this.sKa = jSONObject.optString("right_button_wording");
        }
    }
}
