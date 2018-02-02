package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements Runnable {
    final /* synthetic */ d feT;
    private int feW = 0;

    d$5(d dVar) {
        this.feT = dVar;
    }

    public final void run() {
        int i = 0;
        try {
            d.b(this.feT).lock();
            boolean z = d.c(this.feT) != null && d.c(this.feT).isBinderAlive();
            x.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", new Object[]{d.c(this.feT), Boolean.valueOf(z)});
            if (z) {
                x.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                return;
            }
            d.b(this.feT).unlock();
            x.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.feW)}));
            if (this.feW == 1) {
                int cp = d.cp("com.tencent.mm:push");
                if (cp != -1) {
                    x.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(cp)}));
                    x.cfk();
                    Process.killProcess(cp);
                } else {
                    x.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                }
            }
            Context context = ac.getContext();
            Intent intent = new Intent(context, CoreService.class);
            try {
                x.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                context.unbindService(this.feT);
            } catch (Exception e) {
            } finally {
                context.stopService(intent);
                i = this.feT;
                context.bindService(intent, i, 1);
                context.startService(intent);
            }
            if (this.feW == 1) {
                this.feW = i;
            } else {
                this.feW++;
            }
            ag.h(this, 10000);
            x.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.feW)}));
        } finally {
            d.b(this.feT).unlock();
        }
    }
}
