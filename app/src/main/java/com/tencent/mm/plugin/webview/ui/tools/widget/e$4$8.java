package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.e.4;

class e$4$8 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 4 tKr;

    e$4$8(4 4, Bundle bundle) {
        this.tKr = 4;
        this.fhp = bundle;
    }

    public final void run() {
        if (this.tKr.tKp.tFj != null && this.tKr.tKp.tGR != null && this.tKr.tKp.tGR.bSs() != null && this.tKr.tKp.tGR.bSs().gn(42)) {
            this.tKr.tKp.tFj.f(this.fhp, "download_fail");
        }
    }
}
