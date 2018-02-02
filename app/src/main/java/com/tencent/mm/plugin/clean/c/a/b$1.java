package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class b$1 implements Runnable {
    final /* synthetic */ b lfP;

    b$1(b bVar) {
        this.lfP = bVar;
    }

    public final void run() {
        Looper.prepare();
        this.lfP.lfN.put(Long.valueOf(Thread.currentThread().getId()), new af(Looper.myLooper()));
        Looper.loop();
    }
}
