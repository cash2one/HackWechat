package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public b(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        D(hashMap);
    }

    public final int ayQ() {
        return 9;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i + " errMsg: " + str);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    public final int Hr() {
        return 468;
    }
}
