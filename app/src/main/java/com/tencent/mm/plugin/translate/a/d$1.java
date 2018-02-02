package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ d sgo;

    d$1(d dVar) {
        this.sgo = dVar;
    }

    public final boolean uF() {
        if (this.sgo.sgk) {
            x.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[]{Integer.valueOf(this.sgo.index)});
            this.sgo.bFB();
            this.sgo.sgm.a(-1, this.sgo.sgj, null);
        }
        return false;
    }
}
