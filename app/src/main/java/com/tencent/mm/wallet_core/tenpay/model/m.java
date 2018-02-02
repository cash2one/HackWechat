package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends i {
    public m() {
        D(new HashMap());
    }

    public final int ayQ() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (bh.ov(optString)) {
            x.w("Micromsg.NetSceneTenpayTimeSeed", "hy: no timeseed. use local timeseed");
            n.setTimeStamp((System.currentTimeMillis() / 1000));
            return;
        }
        n.setTimeStamp(optString);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/timeseed";
    }

    public final int Hr() {
        return 477;
    }
}
