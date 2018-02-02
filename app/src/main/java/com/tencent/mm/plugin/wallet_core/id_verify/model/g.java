package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends i {
    public int sIK;
    public int sIL;
    public Profession[] sKc = null;

    public g() {
        Map hashMap = new HashMap();
        if (!bh.ov(null)) {
            hashMap.put("scene", null);
        }
        D(hashMap);
    }

    public final int ayQ() {
        return 1976;
    }

    public final int Hr() {
        return 1976;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getuserexinfo";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        x.i("MicroMsg.NetSceneTenpayGetUserExInfo", "errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        x.d("MicroMsg.NetSceneTenpayGetUserExInfo", "json: %s", new Object[]{jSONObject.toString()});
        this.sIK = jSONObject.optInt("need_area");
        this.sIL = jSONObject.optInt("need_profession");
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        if (optJSONArray != null) {
            this.sKc = new Profession[optJSONArray.length()];
            while (i2 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("profession_name");
                    int optInt = optJSONObject.optInt("profession_type");
                    if (bh.ov(optString)) {
                        x.i("MicroMsg.NetSceneTenpayGetUserExInfo", "empty profession_name!");
                    } else {
                        this.sKc[i2] = new Profession(optString, optInt);
                    }
                }
                i2++;
            }
        }
    }
}
