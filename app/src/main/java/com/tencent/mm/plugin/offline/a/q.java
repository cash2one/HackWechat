package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.Map;
import org.json.JSONObject;

public final class q extends i {
    public n oWY;
    public x oWZ = new x(null, 8);
    public c oXa;
    public c oXb;

    public q(int i) {
        this.oWY = new n(System.currentTimeMillis(), i);
        D(this.oWY.oWX);
        aA(this.oWZ.oWX);
        aB(this.oWZ.sEq);
    }

    public final int ayQ() {
        return 1742;
    }

    public final int Hr() {
        return 1742;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineuserbindquery";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("queryuser_resp");
            this.oXa = M(optJSONObject);
            this.oWY.a(this.oXa.errCode, this.oXa.fnL, optJSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("bindquerynew_resp");
            this.oXb = M(optJSONObject2);
            this.oWZ.a(this.oXb.errCode, this.oXb.fnL, optJSONObject2);
            String optString = optJSONObject.optString("card_list");
            if (optString != null) {
                a.GV(optString);
            }
        }
    }

    private static c M(JSONObject jSONObject) {
        String optString;
        int i;
        c cVar = new c();
        cVar.fnL = ac.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uRf);
        String string = ac.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uRf);
        try {
            int i2 = jSONObject.getInt("retcode");
            optString = jSONObject.optString("retmsg");
            i = i2;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: json resolve error: error when resolving error code : " + e.toString());
            optString = string;
            i = -10089;
        }
        if (i != 0) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: resolve busi error: retCode is error");
            if (i != -10089) {
                cVar.c(1000, i, optString, 2);
            } else {
                cVar.c(1000, 2, optString, 2);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "hy: all's OK");
        }
        return cVar;
    }

    public static boolean isEnabled() {
        boolean z = false;
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100337");
        if (fn.isValid()) {
            Map chI = fn.chI();
            String str = "enabled";
            if (chI.containsKey(str) && "1".equals(chI.get(str))) {
                z = true;
            }
        }
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.NetSceneTenpayWxOfflineUserBindQuery", "isUserBindQueryEnabled: " + z);
        return z;
    }
}
