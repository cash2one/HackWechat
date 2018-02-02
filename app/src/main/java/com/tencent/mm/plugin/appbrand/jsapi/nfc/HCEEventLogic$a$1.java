package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.HCEMMToAppBrandMessageEvent;
import com.tencent.mm.sdk.platformtools.x;

class HCEEventLogic$a$1 implements a {
    HCEEventLogic$a$1() {
    }

    public final void aY(Object obj) {
        if (obj instanceof HCEMMToAppBrandMessageEvent) {
            HCEMMToAppBrandMessageEvent hCEMMToAppBrandMessageEvent = (HCEMMToAppBrandMessageEvent) obj;
            x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic HCEMMToAppBrandMessageEvent onCustomDataNotify eventType: %d, appId: %s", Integer.valueOf(HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent)), HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent));
            switch (HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent)) {
                case 12:
                    if (HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent) != null) {
                        HCEEventLogic.k(HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent).getInt("errCode"), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent).getString("errMsg"));
                        return;
                    }
                    return;
                case 31:
                case 41:
                    e oQ = com.tencent.mm.plugin.appbrand.a.oQ(HCEMMToAppBrandMessageEvent.b(hCEMMToAppBrandMessageEvent));
                    if (oQ != null) {
                        a.a(oQ.mAppId, HCEMMToAppBrandMessageEvent.a(hCEMMToAppBrandMessageEvent), HCEMMToAppBrandMessageEvent.c(hCEMMToAppBrandMessageEvent));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
