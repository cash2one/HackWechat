package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends com.tencent.mm.wallet_core.tenpay.model.i {
    public i(String str) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        D(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
    }

    public final int ayQ() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        String str2 = "MicroMsg.NetSceneTouchLockVerifyByPwd";
        String str3 = "alvinluo errCode: %d, errMsg: %s, json: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = jSONObject != null ? jSONObject.toString() : "null";
        x.v(str2, str3, objArr);
    }

    public final int Hr() {
        return 1304;
    }

    public final int a(e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return super.a(eVar, eVar2);
    }
}
