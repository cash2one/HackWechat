package com.tencent.mm.plugin.offline.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("ack_key", a.bif());
        hashMap.put("req_key", a.big());
        hashMap.put("paymsg_type", a.bih());
        hashMap.put("transactionid", a.bii());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, a.getNetworkType(ac.getContext()));
        hashMap.put("processed", k.oWd ? "1" : "0");
        hashMap.put("is_pos_enabled", a.bij() ? "1" : "0");
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put("timestamp", (System.currentTimeMillis() / 1000));
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            x.v(this.TAG, "response ok");
            g.pQN.a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dj().CU().a(w.a.xvq, Integer.valueOf(optInt));
                return;
            }
            return;
        }
        x.v(this.TAG, "response fail");
        g.pQN.a(135, 69, 1, true);
    }

    public final int ayQ() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
