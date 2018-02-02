package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.u.a.a;

class SightCaptureUI$3 implements OnClickListener {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$3(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onClick(View view) {
        if (SightCaptureUI.v(this.oDb)) {
            this.oDb.finish();
            this.oDb.overridePendingTransition(-1, a.oEl);
        }
    }
}
