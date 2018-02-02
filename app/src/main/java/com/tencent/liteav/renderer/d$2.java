package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;

class d$2 implements Runnable {
    final /* synthetic */ d a;

    d$2(d dVar) {
        this.a = dVar;
    }

    public void run() {
        synchronized (this) {
            TXCLog.d("TXCGLSurfaceView", "background capture exit background");
            this.a.e = false;
        }
    }
}
