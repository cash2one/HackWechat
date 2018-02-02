package com.tencent.mm.plugin.appbrand;

import android.app.Dialog;
import com.tencent.mm.plugin.appbrand.r.2;

class r$2$1 implements Runnable {
    final /* synthetic */ 2 iCM;

    r$2$1(2 2) {
        this.iCM = 2;
    }

    public final void run() {
        if (this.iCM.iCJ.jRK != null) {
            ((Dialog) this.iCM.iCJ.jRK).dismiss();
        }
    }
}
