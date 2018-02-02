package com.tencent.mm.plugin.scanner.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$2 extends af {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$2(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void handleMessage(Message message) {
        if (message != null && message.what == 1 && BaseScanUI.k(this.pUR) != null && BaseScanUI.l(this.pUR) != null) {
            if (BaseScanUI.a(this.pUR) && !BaseScanUI.b(this.pUR)) {
                return;
            }
            if (BaseScanUI.h(this.pUR) == null || BaseScanUI.h(this.pUR).boO() <= 0) {
                x.w("MicroMsg.scanner.BaseScanUI", "startAnimHandler scanMode == null");
                this.pUR.boT();
                return;
            }
            BaseScanUI.k(this.pUR).setVisibility(0);
            BaseScanUI.l(this.pUR).setRepeatCount(-1);
            BaseScanUI.l(this.pUR).setDuration(2600);
            BaseScanUI.k(this.pUR).startAnimation(BaseScanUI.l(this.pUR));
        }
    }
}
