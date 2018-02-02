package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.sdk.platformtools.x;

class ExceptionMonitorService$1 implements Runnable {
    final /* synthetic */ ExceptionMonitorService xbZ;

    ExceptionMonitorService$1(ExceptionMonitorService exceptionMonitorService) {
        this.xbZ = exceptionMonitorService;
    }

    public final void run() {
        x.d("MicroMsg.CrashMonitorService", "stopSelf");
        this.xbZ.stopSelf();
    }
}
