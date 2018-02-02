package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.u.a$d;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$11 implements Runnable {
    final /* synthetic */ SightCaptureUI oDb;
    final /* synthetic */ String oDf;

    SightCaptureUI$11(SightCaptureUI sightCaptureUI, String str) {
        this.oDb = sightCaptureUI;
        this.oDf = str;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", new Object[]{this.oDf});
        k.baK();
        if (k.baN()) {
            TextView textView = (TextView) this.oDb.findViewById(a$d.oES);
            textView.setVisibility(0);
            textView.setText(this.oDf);
        }
    }
}
