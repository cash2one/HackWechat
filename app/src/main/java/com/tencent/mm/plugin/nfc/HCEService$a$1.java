package com.tencent.mm.plugin.nfc;

import com.tencent.mm.plugin.nfc.HCEService.a;
import com.tencent.mm.sdk.platformtools.x;

class HCEService$a$1 implements Runnable {
    final /* synthetic */ a oRG;

    HCEService$a$1(a aVar) {
        this.oRG = aVar;
    }

    public final void run() {
        x.i("MicroMsg.HCEService", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", new Object[]{Integer.valueOf(1500), Boolean.valueOf(HCEService.g(this.oRG.oRF))});
        HCEService.a(this.oRG.oRF, true);
        HCEService.a(this.oRG.oRF, HCEService.bfr(), true);
    }
}
