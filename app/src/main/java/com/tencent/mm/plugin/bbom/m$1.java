package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.z.ar;

class m$1 implements Runnable {
    final /* synthetic */ m kvE;

    m$1(m mVar) {
        this.kvE = mVar;
    }

    public final void run() {
        ar.hold();
        MMAppMgr.lW(true);
    }
}
