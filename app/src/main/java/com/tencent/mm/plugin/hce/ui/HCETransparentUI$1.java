package com.tencent.mm.plugin.hce.ui;

import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class HCETransparentUI$1 extends TimerTask {
    final /* synthetic */ HCETransparentUI nAu;

    HCETransparentUI$1(HCETransparentUI hCETransparentUI) {
        this.nAu = hCETransparentUI;
    }

    public final void run() {
        x.i("MicroMsg.HCETransparentUI", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(HCETransparentUI.a(this.nAu)));
        HCETransparentUI.b(this.nAu);
        if (HCETransparentUI.a(this.nAu) > 10) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo loop check count exceed max limit: %d", Integer.valueOf(10));
            HCETransparentUI.c(this.nAu);
            HCETransparentUI.d(this.nAu);
        } else if (b.aSt()) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo loopCheck NFC switch is opened, and cancel task");
            HCETransparentUI.c(this.nAu);
            HCETransparentUI.e(this.nAu);
        }
    }
}
