package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.storage.au;

class ab$2 implements Runnable {
    final /* synthetic */ ab yCv;

    ab$2(ab abVar) {
        this.yCv = abVar;
    }

    public final void run() {
        au ctZ = this.yCv.ctZ();
        if (ctZ != null) {
            this.yCv.e(ctZ, false);
        }
    }
}
