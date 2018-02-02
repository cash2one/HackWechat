package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$24 implements d {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$24(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void bby() {
        x.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", new Object[]{bh.cgy().toString()});
        if (SightCaptureUI.n(this.oDb) != null) {
            x.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", new Object[]{SightCaptureUI.n(this.oDb).baz()});
            SightCaptureUI.n(this.oDb).cancel();
        }
        com.tencent.mm.plugin.mmsight.d.Fg("TIME_RECODER_2_PLAY");
        SightCaptureUI.o(this.oDb);
    }
}
