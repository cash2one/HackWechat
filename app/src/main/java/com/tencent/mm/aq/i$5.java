package com.tencent.mm.aq;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$5 implements a {
    final /* synthetic */ i hBd;

    i$5(i iVar) {
        this.hBd = iVar;
    }

    public final boolean uF() {
        try {
            i.e(this.hBd);
        } catch (Throwable e) {
            x.e("MicroMsg.ImgService", "exception:%s", new Object[]{bh.i(e)});
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|scenePusher";
    }
}
