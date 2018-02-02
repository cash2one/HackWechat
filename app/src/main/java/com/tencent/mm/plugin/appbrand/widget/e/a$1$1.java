package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mm.plugin.appbrand.widget.e.a.1;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements Runnable {
    final /* synthetic */ 1 kct;

    a$1$1(1 1) {
        this.kct = 1;
    }

    public final void run() {
        synchronized (this) {
            Runnable runnable = (Runnable) a.agw().pollFirst();
            if (runnable != null) {
                runnable.run();
            } else {
                x.i("MicroMsg.BaseMarkerAnimatorJsApi", "markerAnimatorJsApi processed!");
                a.anB();
            }
        }
    }
}
