package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.14;
import com.tencent.mm.plugin.u.a.f;

class SightCaptureUI$14$2 implements Runnable {
    final /* synthetic */ 14 oDh;

    SightCaptureUI$14$2(14 14) {
        this.oDh = 14;
    }

    public final void run() {
        Toast.makeText(this.oDh.oDb, f.oyv, 1).show();
        this.oDh.oDb.DR(8);
        this.oDh.oDb.oCm.setVisibility(0);
        this.oDh.oDb.nWC.setVisibility(0);
        this.oDh.oDb.oCr.setVisibility(0);
    }
}
