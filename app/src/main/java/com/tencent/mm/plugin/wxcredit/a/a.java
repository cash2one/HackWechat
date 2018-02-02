package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public String fAf;
    public boolean fKI = true;
    private Map<String, String> oWX = new HashMap();
    public boolean tYW = false;
    public String token;

    public a(String str, String str2, String str3, String str4) {
        this.oWX.put("session_key", str3);
        this.oWX.put("bank_type", str4);
        this.oWX.put("name", str);
        this.oWX.put("cre_id", str2);
        D(this.oWX);
    }

    public final boolean bhc() {
        super.bhc();
        this.oWX.put("retry", "1");
        D(this.oWX);
        return true;
    }

    public final int ayQ() {
        return 64;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.token = jSONObject.optString("session_key");
                this.fKI = "1".equals(jSONObject.getString("need_bind"));
                this.tYW = "1".equals(jSONObject.getString("bank_user"));
                this.fAf = jSONObject.optString("mobile_no");
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
