package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$18 implements Runnable {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$18(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void run() {
        if (SightCaptureUI.e(this.oDb) != 4) {
            x.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
            SightCaptureUI.g(this.oDb, 9);
        }
    }
}
