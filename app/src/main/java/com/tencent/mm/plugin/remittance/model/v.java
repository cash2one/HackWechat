package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class v extends i {
    public double ljg;
    public String pLA;
    public String pLB;
    private String pLr = null;
    public int pLs;
    private String pLt;
    public String pLu;
    public boolean pLv;
    public int pLw;
    public String pLx;
    public String pLy;
    public int pLz;
    public String paX;
    public String paz;
    public int pbh;
    public int status;

    public v(int i, String str, String str2, int i2) {
        this.pLr = str;
        this.pbh = i;
        Map hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i2));
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1628;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.pLs = jSONObject.optInt("pay_time");
            this.ljg = jSONObject.optDouble("fee") / 100.0d;
            this.paz = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("trans_status");
            this.pLt = jSONObject.optString("trans_status_name");
            this.pLw = jSONObject.optInt("modify_time");
            this.pLv = jSONObject.optBoolean("is_payer");
            this.paX = jSONObject.optString("refund_bank_type");
            this.pLx = jSONObject.optString("status_desc");
            this.pLy = jSONObject.optString("status_supplementary");
            this.pLz = jSONObject.optInt("delay_confirm_flag");
            this.pLA = jSONObject.optString("banner_content");
            this.pLB = jSONObject.optString("banner_url");
        }
    }
}
