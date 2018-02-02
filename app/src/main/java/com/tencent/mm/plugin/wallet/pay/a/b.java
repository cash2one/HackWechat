package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends i {
    public String desc;
    public double pKW;
    public String paz;

    public b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        D(hashMap);
    }

    public final int ayQ() {
        return 123;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.paz = jSONObject.optString("fee_type");
            this.pKW = jSONObject.optDouble("total_fee") / 100.0d;
            JSONArray optJSONArray = jSONObject.optJSONArray("Array");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.desc = ((JSONObject) optJSONArray.opt(0)).optString("desc");
            }
            ad bLr = o.bLr();
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            bLr.sPU.clear();
            if (optJSONObject == null) {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "parse from json error,json is null");
                return;
            }
            JSONObject jSONObject2;
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("Array");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list is null");
            } else {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    d bKU = d.bKU();
                    try {
                        jSONObject2 = (JSONObject) optJSONArray2.get(i2);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WalletRepaymentBankcardMgr", e, "", new Object[0]);
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null) {
                        Bankcard V = bKU.V(jSONObject2);
                        if (V.bKP()) {
                            V.field_desc = V.field_bankName;
                        } else if (V.bKR()) {
                            V.field_desc = ac.getContext().getString(a.i.uRd, new Object[]{V.field_bankName, V.field_bankcardTail});
                        } else if (V.bKO()) {
                            V.field_desc = ac.getContext().getString(a.i.uXU, new Object[]{V.field_bankName, V.field_bankcardTail});
                        } else {
                            V.field_desc = ac.getContext().getString(a.i.uRs, new Object[]{V.field_bankName, V.field_bankcardTail});
                        }
                        bLr.sPU.add(V);
                    }
                }
            }
            jSONObject2 = optJSONObject.optJSONObject("user_info");
            if (jSONObject2 != null) {
                bLr.sPV = jSONObject2.optString("last_card_bind_serialno");
            } else {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "user_info is null");
            }
        }
    }

    public final int Hr() {
        return 1603;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankloanordershow";
    }
}
