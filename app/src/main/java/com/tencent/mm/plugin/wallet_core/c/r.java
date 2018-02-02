package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r extends i {
    public String sIC;
    private int scene;
    public String token;

    public r(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("req_key", str2);
        if (i == 6) {
            hashMap.put("time_stamp", System.currentTimeMillis());
        }
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        if (o.cBs()) {
            hashMap.put("uuid_for_bindcard", o.cBu());
            hashMap.put("bindcard_scene", o.cBt());
        }
        aB(hashMap);
        this.scene = i;
    }

    public final int ayQ() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (this.scene == 6 || this.scene == 8 || this.scene == 18) {
            this.token = jSONObject.optString("usertoken");
            this.sIC = jSONObject.optString("token_type");
        }
    }

    public final int Hr() {
        return 476;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/checkpwd";
    }
}
