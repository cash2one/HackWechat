package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    b$1() {
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SightVideoJNI.freeAll();
        } catch (Throwable e) {
            x.e("MicroMsg.SightPlayController", "free all sight error");
            x.printErrStackTrace("MicroMsg.SightPlayController", e, "", new Object[0]);
        }
        x.i("MicroMsg.SightPlayController", "free all, use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
