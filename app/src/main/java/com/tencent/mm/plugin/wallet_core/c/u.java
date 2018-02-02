package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class u extends i {
    public u(String str, String str2, String str3, String str4, String str5) {
        Map hashMap = new HashMap();
        try {
            hashMap.put("appid", URLEncoder.encode(str, "UTF-8"));
            hashMap.put("timestamp", URLEncoder.encode(str2, "UTF-8"));
            hashMap.put("noncestr", URLEncoder.encode(str3, "UTF-8"));
            hashMap.put("package", URLEncoder.encode(str4, "UTF-8"));
            hashMap.put("sign", URLEncoder.encode(str5, "UTF-8"));
            D(hashMap);
            x.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "package: %s, sign: %s", new Object[]{str4, str5});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneTenpayF2fJsapiCheck", e, "", new Object[0]);
        }
    }

    public final int ayQ() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlistjsapicheck";
    }

    public final int Hr() {
        return 1973;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayF2fJsapiCheck", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
    }
}
