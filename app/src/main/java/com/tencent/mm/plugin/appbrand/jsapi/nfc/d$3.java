package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.b;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class d$3 implements b {
    final /* synthetic */ d joR;

    d$3(d dVar) {
        this.joR = dVar;
    }

    public final void l(String str, int i, String str2) {
        d dVar = this.joR;
        synchronized (dVar.mLock) {
            boolean z = dVar.joQ;
            if (!z) {
                dVar.joQ = true;
            }
        }
        if (z) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
            return;
        }
        Map hashMap = new HashMap();
        int currentTimeMillis = (int) (System.currentTimeMillis() - dVar.mStartTime);
        if (dVar.bnp != null) {
            x.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
            dVar.bnp.cancel();
        }
        if (str == null || str.equals(dVar.iqB.mAppId)) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str2});
            if (i == 0) {
                HCEEventLogic.sE(dVar.iqB.mAppId);
                hashMap.put("errCode", Integer.valueOf(0));
                dVar.sj(dVar.e("ok", hashMap));
            } else {
                hashMap.put("errCode", Integer.valueOf(i));
                dVar.sj(dVar.e("fail: " + str2, hashMap));
            }
            c.N(dVar.iqB.mAppId, i, currentTimeMillis);
            HCEEventLogic.a(null);
            return;
        }
        x.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[]{str});
        hashMap.put("errCode", Integer.valueOf(13010));
        c.N(dVar.iqB.mAppId, 13010, currentTimeMillis);
        dVar.sj(dVar.e("fail: unknown error", hashMap));
        HCEEventLogic.a(null);
    }
}
