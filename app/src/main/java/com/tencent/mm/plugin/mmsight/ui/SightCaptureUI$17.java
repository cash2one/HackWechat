package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$17 implements Runnable {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$17(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void run() {
        if (SightCaptureUI.e(this.oDb) == 7 && SightCaptureUI.i(this.oDb) != null) {
            x.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
            MMSightRecordButton i = SightCaptureUI.i(this.oDb);
            x.i("MicroMsg.MMSightRecordButton", "showProgressBar");
            i.oAZ.setVisibility(0);
        }
    }
}
