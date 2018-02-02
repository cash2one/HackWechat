package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$1 implements Runnable {
    final /* synthetic */ long mUn;
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$1(SightCaptureUI sightCaptureUI, long j) {
        this.oDb = sightCaptureUI;
        this.mUn = j;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[]{Long.valueOf(bh.bA(this.mUn))});
        j.b(SightCaptureUI.a(this.oDb).oqJ);
        SightCaptureUI.b(this.oDb);
    }
}
