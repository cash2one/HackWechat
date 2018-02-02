package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.19.1;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$19$1$1 implements Runnable {
    final /* synthetic */ 1 oDj;

    SightCaptureUI$19$1$1(1 1) {
        this.oDj = 1;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
        if (SightCaptureUI.S(this.oDj.oDi.oDb) != null) {
            SightCaptureUI.S(this.oDj.oDi.oDb).setAlpha(1.0f);
            SightCaptureUI.g(this.oDj.oDi.oDb, 4);
            SightCaptureUI.F(this.oDj.oDi.oDb);
        }
    }
}
