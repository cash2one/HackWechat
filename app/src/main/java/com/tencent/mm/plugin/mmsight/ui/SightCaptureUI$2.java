package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SightCaptureUI$2 implements OnClickListener {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$2(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.u(this.oDb) != null) {
            SightCaptureUI.u(this.oDb).zd();
        }
        SightCaptureUI.q(this.oDb);
        SightCaptureUI.a(this.oDb, true);
    }
}
