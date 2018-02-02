package com.tencent.mm.plugin.mmsight.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.10;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$10$1 implements Runnable {
    final /* synthetic */ String oDf;
    final /* synthetic */ 10 oDg;

    SightCaptureUI$10$1(10 10, String str) {
        this.oDg = 10;
        this.oDf = str;
    }

    public final void run() {
        x.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", new Object[]{this.oDf});
        k.baK();
        if (k.baN()) {
            TextView textView = (TextView) this.oDg.oDb.findViewById(d.oES);
            textView.setVisibility(0);
            textView.setText(this.oDf);
        }
    }
}
