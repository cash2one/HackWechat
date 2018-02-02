package com.tencent.mm.plugin.appbrand.config;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.config.o.2;

class o$2$2 implements IdleHandler {
    final /* synthetic */ 2 iPa;

    o$2$2(2 2) {
        this.iPa = 2;
    }

    public final boolean queueIdle() {
        this.iPa.iOZ.oAt.quit();
        return false;
    }
}
