package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a sQN = null;

    public static a bMj() {
        if (sQN == null) {
            sQN = new a();
        }
        return sQN;
    }

    public final Bankcard V(JSONObject jSONObject) {
        Bankcard V = super.V(jSONObject);
        V.field_ext_msg = b.ac(jSONObject);
        V.field_bankcardClientType = 1;
        V.field_desc = jSONObject.optString("description");
        V.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            V.field_cardType |= Bankcard.sKS;
        } else {
            V.field_cardType |= Bankcard.sKU;
        }
        return V;
    }
}
