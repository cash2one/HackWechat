package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.c;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends i {
    private boolean fHt = true;

    public f(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("code_ver", str);
        hashMap.put("cn", str2);
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "reqtoken ver %s cn: %s", new Object[]{str, str2});
        D(hashMap);
    }

    public final int ayQ() {
        return 1686;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineverifytoken";
    }

    public final int Hr() {
        return 1686;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "respone %d errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (i == 0) {
            x.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken succ");
            g.pQN.a(135, 22, 1, true);
            return;
        }
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "NetSceneOfflineVerifyToken fail.errCode = %d ;errMsg = ", new Object[]{Integer.valueOf(i), str});
        g.pQN.a(135, 23, 1, true);
    }

    public final void a(c cVar, JSONObject jSONObject) {
        if (cVar.zHk != 0 || cVar.errType == 0) {
            this.fHt = true;
        } else {
            this.fHt = false;
        }
        x.i("MicroMsg.NetSceneOfflineVerifyToken", "onGYNetEnd2 isBlock %s", new Object[]{Boolean.valueOf(this.fHt)});
    }

    public final boolean bhd() {
        return this.fHt;
    }
}
