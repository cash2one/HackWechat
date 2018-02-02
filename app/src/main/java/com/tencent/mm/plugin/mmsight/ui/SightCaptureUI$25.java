package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$25 implements OnClickListener {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$25(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.h(this.oDb) != null) {
            SightCaptureUI.r(this.oDb);
        }
    }
}
