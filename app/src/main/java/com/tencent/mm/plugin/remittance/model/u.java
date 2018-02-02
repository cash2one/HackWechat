package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends i {
    public String desc;
    public double ljg;
    public String pLd;
    public String pLe;
    public String pLf = "";
    public String pLg = "";
    public String pLh = "";
    public String pLi = "";
    public int pLj;
    public String pLk = "";
    public String pLl = "";
    public int pLm;
    public String pLn;
    public String pLo;
    public int pLp;
    public BusiRemittanceResp pLq;
    public int scene;
    public String username;

    public u(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", URLEncoder.encode(str));
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("channel", String.valueOf(i));
        aB(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferscanqrcode";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "errCode " + i + " errMsg: " + str);
            if (i == 0) {
                x.d("Micromsg.NetSceneTenpayRemittanceGetUsername", "json %s", new Object[]{jSONObject.toString()});
                this.username = jSONObject.optString("user_name", "");
                this.pLd = jSONObject.optString("true_name");
                this.ljg = jSONObject.optDouble("fee") / 100.0d;
                this.desc = jSONObject.optString("desc");
                this.scene = jSONObject.optInt("scene");
                this.pLe = URLEncoder.encode(jSONObject.optString("transfer_qrcode_id"));
                this.pLf = jSONObject.optString("f2f_pay_desc");
                this.pLg = jSONObject.optString("rcvr_desc");
                this.pLh = jSONObject.optString("payer_desc");
                this.pLi = jSONObject.optString("rcvr_ticket");
                this.pLj = jSONObject.optInt("busi_type", 0);
                this.pLk = jSONObject.optString("mch_name");
                this.pLl = jSONObject.optString("mch_photo");
                this.pLo = jSONObject.optString("mch_type", "");
                this.pLm = jSONObject.optInt("mch_time", 0);
                this.pLn = jSONObject.optString("receiver_openid");
                this.pLp = jSONObject.optInt("get_pay_wifi");
                this.pLq = new BusiRemittanceResp(jSONObject);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("Micromsg.NetSceneTenpayRemittanceGetUsername", e, "", new Object[0]);
        }
    }
}
