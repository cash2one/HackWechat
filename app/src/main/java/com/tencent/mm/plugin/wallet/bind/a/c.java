package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends i {
    public boolean fKH = false;
    public boolean sBN = true;
    public String sBO;
    public String sBP;
    private String sBQ;
    public ArrayList<Bankcard> szk = null;
    public String token;

    public c(String str, PayInfo payInfo) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        g.Dk();
        o oVar = new o(bh.a((Integer) g.Dj().CU().get(9, null), 0));
        this.sBQ = str;
        hashMap.put("import_code", str);
        hashMap.put("qqid", oVar.toString());
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 37;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            this.szk = new ArrayList();
            try {
                this.fKH = "1".equals(jSONObject.optString("is_reg", "0"));
                this.token = jSONObject.optString("token", "");
                JSONArray jSONArray = jSONObject.getJSONArray("Array");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Bankcard V = d.bKU().V(jSONObject2);
                    if (V != null) {
                        if ((2 == jSONObject2.optInt("bank_acc_type", 2) ? 1 : null) != null) {
                            V.field_cardType |= Bankcard.sKS;
                        }
                        V.field_bankcardTail = jSONObject2.optString("bank_tail");
                        V.sLa = "************" + V.field_bankcardTail;
                        V.field_trueName = jSONObject2.optString("true_name");
                        V.sKZ = jSONObject2.optString("cre_id");
                        V.sKv = jSONObject2.optInt("cre_type", -1);
                        V.sLl = this.sBQ;
                        V.sLm = 1 == jSONObject2.optInt("samecardexist", 0);
                        if (V.bKP()) {
                            V.field_desc = V.field_bankName;
                        } else if (V.bKR()) {
                            V.field_desc = ac.getContext().getString(a.i.uRd, new Object[]{V.field_bankName, V.field_bankcardTail});
                        } else if (V.bKO()) {
                            V.field_desc = ac.getContext().getString(a.i.uXU, new Object[]{V.field_bankName, V.field_bankcardTail});
                        } else {
                            V.field_desc = ac.getContext().getString(a.i.uRs, new Object[]{V.field_bankName, V.field_bankcardTail});
                        }
                        JSONObject optJSONObject = jSONObject2.optJSONObject("bankappservice");
                        if (optJSONObject != null) {
                            this.sBO = optJSONObject.optString("username");
                            this.sBP = optJSONObject.optString("app_recommend_desc");
                        }
                        this.szk.add(V);
                    }
                }
                x.d("MicroMsg.NetSceneTenpayQueryBindBankcard", "got data---isReg:" + this.fKH + ",bankcard.size:" + this.szk.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryBindBankcard", e, "", new Object[0]);
            }
        }
    }
}
