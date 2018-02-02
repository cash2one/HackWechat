package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$22 implements MMSightRecordButton$a {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$22(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void bbu() {
        x.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", new Object[]{bh.cgy().toString()});
        if (SightCaptureUI.n(this.oDb) != null) {
            SightCaptureUI.n(this.oDb).cancel();
            if (SightCaptureUI.j(this.oDb) == 0) {
                SightCaptureUI.o(this.oDb);
            }
        }
    }
}
