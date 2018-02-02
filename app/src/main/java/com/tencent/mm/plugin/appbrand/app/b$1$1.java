package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.app.b.1;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements IdleHandler {
    final /* synthetic */ 1 iCU;

    b$1$1(1 1) {
        this.iCU = 1;
    }

    public final boolean queueIdle() {
        Looper.myQueue().removeIdleHandler(this);
        if (!b.ya()) {
            x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload");
            AppBrandMainProcessService.afb();
            c.a(null, false);
        }
        return false;
    }
}
