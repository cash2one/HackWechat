package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$1 implements Runnable {
    final /* synthetic */ b mbW;

    b$1(b bVar) {
        this.mbW = bVar;
    }

    public final void run() {
        if (ar.Hj() && !bh.ov(this.mbW.gQi)) {
            long currentTimeMillis = System.currentTimeMillis();
            bh.g(this.mbW.gQi + "image/spen/", "spen_", 259200000);
            x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
    }
}
