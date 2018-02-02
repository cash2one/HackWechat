package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.wallet_core.b.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x extends a {
    public int liR = 0;
    public String liT;
    public String liU;
    public String pLC = "";
    public String pLD = "";

    public x(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTenpayh5Index create");
        Map hashMap = new HashMap();
        hashMap.put("wallet_type", String.valueOf(i));
        D(hashMap);
    }

    public final int ayO() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayh5Index", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayh5Index", "NetSceneTransferChargeQuery request error");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        this.liR = jSONObject.optInt("currency");
        this.pLC = jSONObject.optString("currencyUint");
        this.pLD = jSONObject.optString("currencyWording");
        this.liT = jSONObject.optString("notice");
        this.liU = jSONObject.optString("notice_url");
        stringBuffer.append("currency:" + this.liR);
        stringBuffer.append(" currencyuint:" + this.pLC);
        stringBuffer.append(" currencywording:" + this.pLD);
        stringBuffer.append(" notice:" + this.liT);
        stringBuffer.append(" notice_url:" + this.liU);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayh5Index", "resp " + stringBuffer.toString());
    }

    public final int getType() {
        return 1574;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/h5transferoperate";
    }
}
