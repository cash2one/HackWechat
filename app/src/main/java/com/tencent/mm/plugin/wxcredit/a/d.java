package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public k tZa;

    public d(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("bind_serialno", str);
        hashMap.put("bank_type", str2);
        hashMap.put("query_method", "1");
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("banktype", str2);
        aB(hashMap);
    }

    public final int ayQ() {
        return 57;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        boolean z = true;
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.tZa = new k();
                this.tZa.tZe = jSONObject.optInt("credit_state");
                this.tZa.tYZ = ((double) jSONObject.optInt("credit_amount")) / 100.0d;
                this.tZa.tZf = ((double) jSONObject.optInt("credit_usable")) / 100.0d;
                this.tZa.tZg = ((double) jSONObject.optInt("bill_amount")) / 100.0d;
                this.tZa.tZh = jSONObject.optInt("bill_date");
                this.tZa.tZi = ((double) jSONObject.optInt("repay_amount")) / 100.0d;
                this.tZa.tZj = ((double) jSONObject.optInt("repay_minimum")) / 100.0d;
                k kVar = this.tZa;
                if (jSONObject.optInt("upgrade_amount") != 1) {
                    z = false;
                }
                kVar.tZk = z;
                this.tZa.tZl = jSONObject.optInt("bill_month");
                this.tZa.tZm = jSONObject.optString("repay_url");
                this.tZa.tZn = jSONObject.optString("repay_lasttime");
                this.tZa.tZr = jSONObject.optString("lasttime");
                JSONArray jSONArray = jSONObject.getJSONArray("jump_url_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String string = jSONObject2.getString("jump_name");
                        if ("account_rights_url".equals(string)) {
                            this.tZa.tZp = jSONObject2.getString("jump_url");
                        } else if ("bill_url".equals(string)) {
                            this.tZa.tZq = jSONObject2.getString("jump_url");
                        } else if ("card_detail_url".equals(string)) {
                            this.tZa.tZo = jSONObject2.getString("jump_url");
                        } else if ("know_more_url".equals(string)) {
                            this.tZa.tZs = jSONObject2.getString("jump_url");
                        }
                    }
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("appservice");
                if (jSONObject3 != null) {
                    this.tZa.tZt = new j();
                    this.tZa.tZt.tZd = jSONObject3.getString("app_telephone");
                    this.tZa.tZt.fpL = jSONObject3.getString("nickname");
                    this.tZa.tZt.username = jSONObject3.getString("username");
                    this.tZa.tZt.url = jSONObject3.getString("jump_url");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
