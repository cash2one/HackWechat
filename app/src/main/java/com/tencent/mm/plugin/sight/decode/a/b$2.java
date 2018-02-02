package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b qtU;
    final /* synthetic */ int val$id;

    b$2(b bVar, int i) {
        this.qtU = bVar;
        this.val$id = i;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        SightVideoJNI.freeObj(this.val$id);
        x.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
