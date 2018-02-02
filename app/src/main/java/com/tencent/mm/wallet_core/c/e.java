package com.tencent.mm.wallet_core.c;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends i {
    public String zHl;

    public e(String str) {
        this.zHl = str;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap.put("crt_no", p.encode(str));
        hashMap.put("deviceid", q.getDeviceID(ac.getContext()));
        D(hashMap);
        aB(hashMap2);
    }

    public final int ayQ() {
        return 1568;
    }

    public final int Hr() {
        return 1568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/deletedigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneDeletedigitalcert", "onGYNetEnd %d %s", new Object[]{Integer.valueOf(i), str});
    }
}
