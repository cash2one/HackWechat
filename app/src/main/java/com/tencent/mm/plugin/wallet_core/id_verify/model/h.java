package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends i {
    public h(String str, String str2, String str3, Profession profession) {
        x.d("MicroMsg.NetSceneTenpaySetUserExInfo", "country: %s, province: %s, city: %s", new Object[]{str, str2, str3});
        Map hashMap = new HashMap();
        if (!bh.ov(str)) {
            hashMap.put("user_country", str);
        }
        if (!bh.ov(str2)) {
            hashMap.put("user_province", str2);
        }
        if (!bh.ov(str3)) {
            hashMap.put("user_city", str3);
        }
        if (profession != null) {
            x.d("MicroMsg.NetSceneTenpaySetUserExInfo", "name: %s, type: %s", new Object[]{profession.sKd, Integer.valueOf(profession.sKe)});
            hashMap.put("profession_name", profession.sKd);
            hashMap.put("profession_type", String.valueOf(profession.sKe));
        }
        D(hashMap);
    }

    public final int ayQ() {
        return 1978;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTenpaySetUserExInfo", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserexinfo";
    }

    public final int Hr() {
        return 1978;
    }
}
