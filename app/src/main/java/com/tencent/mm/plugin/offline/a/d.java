package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i {
    public String oWm;
    public int oWn;
    public String oWo;

    public d() {
        Map hashMap = new HashMap();
        g.Dk();
        Object obj = g.Dj().CU().get(a.xvr, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put("timestamp", System.currentTimeMillis());
        D(hashMap);
    }

    public final int ayQ() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pQN.a(135, 56, 1, true);
            this.oWm = jSONObject.optString("appmsg");
            this.oWn = jSONObject.optInt("poll_time") * 1000;
            this.oWo = jSONObject.optString("ack_key");
            if (this.oWn > 0) {
                g.Dk();
                g.Dj().CU().a(a.xvq, Integer.valueOf(this.oWn));
            }
            g.Dk();
            g.Dj().CU().a(a.xvr, this.oWo);
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(135, 57, 1, true);
    }

    public final boolean bhc() {
        return false;
    }
}
