package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.plugin.ext.c.e.1;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements p {
    final /* synthetic */ 1 mbq;

    e$1$1(1 1) {
        this.mbq = 1;
    }

    public final void F(String str, int i, int i2) {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (bh.ov(str)) {
            x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
            this.mbq.bX(null);
            return;
        }
        this.mbq.bX(new a(i, str, i2));
    }
}
