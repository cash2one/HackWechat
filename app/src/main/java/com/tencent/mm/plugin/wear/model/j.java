package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    HandlerThread handlerThread;
    af jzN;

    private class a extends af {
        final /* synthetic */ j tiF;

        public a(j jVar, Looper looper) {
            this.tiF = jVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                } catch (Exception e) {
                    x.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", new Object[]{dVar.getName()});
                }
            }
        }
    }

    public j() {
        if (com.tencent.mm.compatible.util.d.fO(18)) {
            this.handlerThread = e.Wf("WearWorker_worker_thread");
            this.handlerThread.start();
            this.jzN = new a(this, this.handlerThread.getLooper());
            x.i("MicroMsg.Wear.WearWorker", "start worker %d", new Object[]{Integer.valueOf(this.handlerThread.getThreadId())});
        }
    }

    public final void a(d dVar) {
        if (this.jzN != null) {
            this.jzN.sendMessage(this.jzN.obtainMessage(0, dVar));
        }
    }
}
