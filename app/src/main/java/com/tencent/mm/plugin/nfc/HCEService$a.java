package com.tencent.mm.plugin.nfc;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nfc.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class HCEService$a implements a {
    final /* synthetic */ HCEService oRF;

    private HCEService$a(HCEService hCEService) {
        this.oRF = hCEService;
    }

    public final void dB(String str, String str2) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[]{str, str2});
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_apdu_command", str2);
        HCEService.d(str, bundle);
        HCEService.d(this.oRF);
        if (!HCEService.e(this.oRF)) {
            HCEService.f(this.oRF);
            HCEService.a(this.oRF, false);
            HCEService.dR(System.currentTimeMillis());
            g.Dm().g(new 1(this), 1500);
        } else if (HCEService.h(this.oRF)) {
            x.w("MicroMsg.HCEService", "alvinluo HCECOMMAND TimeExceeded, just return default command");
            HCEService.a(this.oRF, HCEService.bfr(), true);
            HCEService.a(this.oRF, false);
        }
    }

    public final void dC(String str, String str2) {
        if (HCEService.i(this.oRF) == null || !HCEService.i(this.oRF).equals(str) || bh.ov(str2)) {
            x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[]{HCEService.i(this.oRF), str, str2});
            return;
        }
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[]{str, str2, b.aD(Base64.decode(str2, 2)), Boolean.valueOf(HCEService.g(this.oRF))});
        HCEService.a(this.oRF, r0, false);
    }
}
