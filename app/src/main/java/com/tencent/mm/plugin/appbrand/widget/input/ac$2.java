package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.jsapi.m.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.sdk.platformtools.x;

class ac$2 implements Runnable {
    final /* synthetic */ ac jZv;

    ac$2(ac acVar) {
        this.jZv = acVar;
    }

    public final void run() {
        if (this.jZv.jZs) {
            f bI = c.bI(this.jZv.jZo);
            if (this.jZv.jZq == null || Math.abs(this.jZv.jZq.x - bI.x) > 1.0f || Math.abs(this.jZv.jZq.y - bI.y) > 1.0f) {
                x.v(this.jZv.TAG, "check long press timeout, but view has moved.");
            } else if (this.jZv.jZr != null) {
                this.jZv.jZs = false;
                this.jZv.jZo.removeCallbacks(this.jZv.jZt);
            }
        }
    }
}
