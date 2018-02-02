package com.tencent.mm.sandbox.updater;

import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.sdk.platformtools.x;

class UpdaterService$2 implements Runnable {
    final /* synthetic */ UpdaterService xdR;

    UpdaterService$2(UpdaterService updaterService) {
        this.xdR = updaterService;
    }

    public final void run() {
        if (UpdaterService.b(this.xdR).size() > 0) {
            for (a isBusy : UpdaterService.b(this.xdR).values()) {
                if (isBusy.isBusy()) {
                    x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                    return;
                }
            }
        }
        if (a.bYw()) {
            x.i("TBSDownloadMgr", "is still busy");
        } else {
            this.xdR.stopSelf();
        }
    }
}
