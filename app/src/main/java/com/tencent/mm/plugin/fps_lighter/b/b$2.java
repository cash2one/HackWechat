package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.gmtrace.GMTrace;

class b$2 implements Runnable {
    final /* synthetic */ b mAD;

    b$2(b bVar) {
        this.mAD = bVar;
    }

    public final void run() {
        GMTrace.releaseBuffer();
    }
}
