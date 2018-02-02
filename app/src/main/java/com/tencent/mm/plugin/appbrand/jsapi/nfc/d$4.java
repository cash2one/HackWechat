package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

class d$4 extends TimerTask {
    final /* synthetic */ d joR;

    d$4(d dVar) {
        this.joR = dVar;
    }

    public final void run() {
        d dVar = this.joR;
        synchronized (dVar.mLock) {
            boolean z = dVar.joQ;
            if (!z) {
                dVar.joQ = true;
            }
        }
        if (z) {
            x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            return;
        }
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[]{Integer.valueOf(10)});
        HCEEventLogic.a(null);
        if (dVar.iqB != null) {
            c.N(dVar.iqB.mAppId, 13007, -2);
        }
        Map hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(13007));
        dVar.sj(dVar.e("fail: start HCEService failed", hashMap));
    }
}
