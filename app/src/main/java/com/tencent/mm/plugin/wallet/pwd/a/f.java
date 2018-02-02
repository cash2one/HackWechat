package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    private Map<String, String> oWX = new HashMap();
    public String token = null;

    public f(Authen authen, boolean z) {
        this.oWX.put("flag", authen.fDt);
        if (!bh.ov(authen.sKB)) {
            this.oWX.put("first_name", authen.sKB);
            this.oWX.put("last_name", authen.sKC);
            this.oWX.put("country", authen.country);
            this.oWX.put("area", authen.fWp);
            this.oWX.put("city", authen.fWq);
            this.oWX.put("address", authen.hxu);
            this.oWX.put("phone_number", authen.nBO);
            this.oWX.put("zip_code", authen.ilY);
            this.oWX.put("email", authen.fWi);
        }
        this.oWX.put("bank_type", authen.oZz);
        if (authen.sKv > 0) {
            this.oWX.put("cre_type", authen.sKv);
        }
        if (!bh.ov(authen.sKt)) {
            this.oWX.put("true_name", authen.sKt);
        }
        if (!bh.ov(authen.sKu)) {
            this.oWX.put("identify_card", authen.sKu);
        }
        this.oWX.put("mobile_no", authen.sIF);
        this.oWX.put("bank_card_id", authen.sKw);
        if (!bh.ov(authen.sKx)) {
            this.oWX.put("cvv2", authen.sKx);
        }
        if (!bh.ov(authen.sKy)) {
            this.oWX.put("valid_thru", authen.sKy);
        }
        this.oWX.put("new_card_reset_pwd", z ? "1" : "0");
        D(this.oWX);
    }

    public final boolean bhc() {
        super.bhc();
        this.oWX.put("is_repeat_send", "1");
        D(this.oWX);
        return true;
    }

    public final int ayQ() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
    }

    public final String bhV() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    public final int Hr() {
        return 469;
    }
}
