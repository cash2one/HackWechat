package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

class ab$3 implements Runnable {
    final /* synthetic */ ab yCv;

    public ab$3(ab abVar) {
        this.yCv = abVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.yCv) {
            ab.ali().clear();
            ab.cue().clear();
        }
        x.i("MicroMsg.TransformImp", "alvinluo unsetTransformFlag cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
