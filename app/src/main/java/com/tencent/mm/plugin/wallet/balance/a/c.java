package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i implements ITenpaySave {
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    public String fwY = null;
    public boolean syc = false;
    public String syd = "";
    public double syg;
    private RetryPayInfo syh;

    public c(double d, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        this.syg = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", this.syg);
        hashMap.put("fee_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("bank_type", str3);
        D(hashMap);
    }

    public final int ayQ() {
        return 74;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fwY = jSONObject.optString("req_key");
            this.syc = "1".equals(jSONObject.optString("should_alert"));
            this.syd = jSONObject.optString("alert_msg");
            if (jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceSave", "get real_name_info %s", optJSONObject.toString());
                this.fKP = optJSONObject.optString("guide_flag");
                this.fKQ = optJSONObject.optString("guide_wording");
                this.fKR = optJSONObject.optString("left_button_wording");
                this.fKS = optJSONObject.optString("right_button_wording");
                this.fKT = optJSONObject.optString("upload_credit_url");
            }
            this.syh = new RetryPayInfo();
            this.syh.X(jSONObject);
        }
    }

    public final int Hr() {
        return 1502;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genpresave";
    }

    public final RetryPayInfo bJl() {
        return this.syh;
    }
}
