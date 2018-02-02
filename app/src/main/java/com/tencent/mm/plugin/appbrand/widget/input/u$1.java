package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import com.tencent.mm.sdk.platformtools.x;

class u$1 implements Runnable {
    final /* synthetic */ u jYI;

    u$1(u uVar) {
        this.jYI = uVar;
    }

    public final void run() {
        if (u.a(this.jYI) != null && z.ak(u.a(this.jYI))) {
            if (u.a(this.jYI).amS()) {
                x.d("MicroMsg.AppBrandSmileyPanelWrapper", "postMeasure inLayout, skip");
                this.jYI.post(this);
                return;
            }
            u.b(this.jYI);
        }
    }
}
