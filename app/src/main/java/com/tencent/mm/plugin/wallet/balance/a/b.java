package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    public int fpr = 0;
    public String fwY = null;
    public double pKL = 0.0d;
    public double pKW = 0.0d;
    public boolean syc = false;
    public String syd = "";
    public com.tencent.mm.plugin.wallet_core.model.b sye;
    public com.tencent.mm.plugin.wallet_core.model.b syf;
    public double syg;

    public b(double d, String str, String str2, int i) {
        Map hashMap = new HashMap();
        this.syg = (double) Math.round(100.0d * d);
        hashMap.put("total_fee", this.syg);
        hashMap.put("fee_type", str);
        hashMap.put("bank_type", str2);
        hashMap.put("operation", String.valueOf(i));
        D(hashMap);
    }

    public final int ayQ() {
        return 75;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceFetch", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fwY = jSONObject.optString("req_key");
            this.syc = "1".equals(jSONObject.optString("should_alert"));
            this.syd = jSONObject.optString("alert_msg");
            this.pKL = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            this.pKW = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
            JSONObject optJSONObject = jSONObject.optJSONObject("first_fetch_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is valid");
                this.sye = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), first_fetch_info is null");
            }
            optJSONObject = jSONObject.optJSONObject("need_charge_fee_info");
            if (optJSONObject != null) {
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is valid");
                this.syf = ab.a(optJSONObject, false);
            } else {
                x.e("Micromsg.NetSceneTenpayBalanceFetch", "getBalanceFetchInfo(), need_charge_fee_info is null");
            }
            this.fpr = jSONObject.optInt("operation", 0);
            x.i("Micromsg.NetSceneTenpayBalanceFetch", "charge_fee:" + this.pKL + " total_fee:" + this.pKW + " operation:" + this.fpr);
            if (jSONObject.has("real_name_info")) {
                optJSONObject = jSONObject.optJSONObject("real_name_info");
                x.i("Micromsg.NetSceneTenpayBalanceFetch", "get real_name_info %s", optJSONObject.toString());
                this.fKP = optJSONObject.optString("guide_flag");
                this.fKQ = optJSONObject.optString("guide_wording");
                this.fKR = optJSONObject.optString("left_button_wording");
                this.fKS = optJSONObject.optString("right_button_wording");
                this.fKT = optJSONObject.optString("upload_credit_url");
            }
        }
    }

    public final int Hr() {
        return 1503;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/genprefetch";
    }
}
