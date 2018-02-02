package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public a(String str) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final int Hr() {
        return 1321;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", new Object[]{Integer.valueOf(i), str, jSONObject});
    }
}
