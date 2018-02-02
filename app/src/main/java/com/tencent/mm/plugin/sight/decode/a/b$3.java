package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ b qtU;
    final /* synthetic */ double qtV;

    public b$3(b bVar, double d) {
        this.qtU = bVar;
        this.qtV = d;
    }

    public final void run() {
        x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qtV), bh.cgy().toString());
        b.a(this.qtU, this.qtV);
    }
}
