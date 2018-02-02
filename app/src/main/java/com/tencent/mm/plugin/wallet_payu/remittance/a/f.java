package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    public int fDt;
    public int fut;
    public double ljg;
    private String pLr;
    public int pLs;
    public String paz;
    public int status;
    public int tdt;
    public int tdu;

    public f(String str, String str2, int i) {
        this(str, str2, i, 1, 0);
    }

    public f(String str, String str2, int i, int i2, int i3) {
        this.pLr = null;
        this.pLr = str;
        this.fut = 1;
        this.fDt = i3;
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.pLs = jSONObject.optInt("pay_time");
            this.ljg = jSONObject.optDouble("total_fee") / 100.0d;
            this.paz = jSONObject.optString("fee_type");
            this.status = jSONObject.optInt("pay_status");
            this.tdt = jSONObject.optInt("refund_time");
            this.tdu = jSONObject.optInt("receive_time");
        }
    }

    public final int bKL() {
        return 25;
    }
}
