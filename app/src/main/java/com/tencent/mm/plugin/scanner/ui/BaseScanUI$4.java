package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$4 implements Runnable {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$4(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
    }

    public final void run() {
        if (BaseScanUI.f(this.pUR) != null) {
            synchronized (BaseScanUI.n(this.pUR)) {
                if (BaseScanUI.r(this.pUR) && BaseScanUI.f(this.pUR) != null) {
                    x.d("MicroMsg.scanner.BaseScanUI", "closeCamera");
                    BaseScanUI.f(this.pUR).release();
                    BaseScanUI.s(this.pUR);
                    BaseScanUI.t(this.pUR);
                    x.d("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
                }
            }
        }
    }
}
