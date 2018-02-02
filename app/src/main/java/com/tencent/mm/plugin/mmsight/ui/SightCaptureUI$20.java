package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$20 implements OnClickListener {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$20(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.e(this.oDb) == 3) {
            SightCaptureUI.f(this.oDb);
        } else if (SightCaptureUI.e(this.oDb) == 4) {
            SightCaptureUI.g(this.oDb);
        }
    }
}
