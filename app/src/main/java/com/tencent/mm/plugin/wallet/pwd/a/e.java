package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends i {
    public e(p pVar) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.sPj);
        hashMap.put("rpasswd", pVar.sPj);
        hashMap.put("verify_code", pVar.sPk);
        hashMap.put("token", pVar.token);
        a(pVar.pCn, hashMap, hashMap2);
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int Hr() {
        return 478;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwd";
    }
}
