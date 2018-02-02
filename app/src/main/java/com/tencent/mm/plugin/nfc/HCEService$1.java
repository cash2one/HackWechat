package com.tencent.mm.plugin.nfc;

import com.tencent.mm.g.a.ia;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class HCEService$1 extends c<ia> {
    final /* synthetic */ HCEService oRF;

    HCEService$1(HCEService hCEService) {
        this.oRF = hCEService;
        this.xen = ia.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ia iaVar = (ia) bVar;
        x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle listener callback, type: %d", new Object[]{Integer.valueOf(iaVar.fyy.type)});
        switch (iaVar.fyy.type) {
            case 13:
                HCEService.c(this.oRF);
                this.oRF.stopSelf();
                break;
            case 21:
                if (HCEService.b(this.oRF) != null) {
                    HCEService.b(this.oRF).onCreate();
                    break;
                }
                break;
            case 22:
                if (HCEService.b(this.oRF) != null) {
                    HCEService.b(this.oRF).onResume();
                    break;
                }
                break;
            case 23:
                if (HCEService.b(this.oRF) != null) {
                    HCEService.b(this.oRF).onPause();
                    break;
                }
                break;
            case 24:
                if (HCEService.b(this.oRF) != null) {
                    HCEService.b(this.oRF).onDestroy();
                    break;
                }
                break;
            case 32:
                if (HCEService.a(this.oRF) != null) {
                    HCEService.a(this.oRF).dC(iaVar.fyy.appId, iaVar.fyy.extras.getString("key_apdu_command"));
                    break;
                }
                break;
        }
        return false;
    }
}
