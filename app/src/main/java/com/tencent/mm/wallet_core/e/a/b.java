package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b() {
        D(new HashMap());
    }

    public final int bKL() {
        return 28;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetScenePayUTimeSeed", " errCode: " + i + " errMsg :" + str);
        String optString = jSONObject.optString("time_stamp");
        if (!bh.ov(optString)) {
            n.setTimeStamp(optString);
        }
    }
}
