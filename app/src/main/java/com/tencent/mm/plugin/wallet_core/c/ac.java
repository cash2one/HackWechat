package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import org.json.JSONObject;

public final class ac extends i {
    public double pKP;
    public String pMh;
    public String sIQ;
    public double sIR;

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            return;
        }
        this.sIQ = jSONObject.optString("short_desc");
        this.pMh = jSONObject.optString("charge_desc");
        this.sIR = jSONObject.optDouble("acc_fee");
        this.pKP = jSONObject.optDouble("remain_fee") / 100.0d;
    }
}
