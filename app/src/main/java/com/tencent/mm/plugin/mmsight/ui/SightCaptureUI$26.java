package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$26 implements OnClickListener {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$26(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.e(this.oDb) == 4) {
            SightCaptureUI.s(this.oDb);
        } else if (SightCaptureUI.e(this.oDb) == 3) {
            SightCaptureUI.t(this.oDb);
            SightCaptureUI.a(this.oDb, false);
        }
    }
}
