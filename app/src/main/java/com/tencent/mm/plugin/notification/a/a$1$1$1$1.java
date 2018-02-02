package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.plugin.notification.a.a.1.1.1;
import com.tencent.mm.z.ar;

class a$1$1$1$1 implements Runnable {
    final /* synthetic */ 1 oTW;

    a$1$1$1$1(1 1) {
        this.oTW = 1;
    }

    public final void run() {
        ar.getNotification().n(this.oTW.oTS, this.oTW.oTV.oTQ);
        if (this.oTW.oTV.oTR.oTP.oTO) {
            this.oTW.oTV.oTR.oTP.oTO = false;
            ar.getNotification().aV(false);
        }
    }
}
