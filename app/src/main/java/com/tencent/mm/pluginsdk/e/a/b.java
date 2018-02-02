package com.tencent.mm.pluginsdk.e.a;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b {
    private CountDownLatch vcS = null;

    public final void countDown() {
        if (this.vcS != null) {
            this.vcS.countDown();
            this.vcS = null;
        }
    }

    public final void b(long j, Runnable runnable) {
        x.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.vcS == null) {
            this.vcS = new CountDownLatch(1);
        }
        ag.y(runnable);
        x.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.vcS != null) {
            try {
                this.vcS.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.w("MicroMsg.SyncJob", e.getMessage());
                x.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
    }
}
