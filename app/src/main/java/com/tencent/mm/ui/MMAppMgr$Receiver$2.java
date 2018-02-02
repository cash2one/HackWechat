package com.tencent.mm.ui;

import com.tencent.mm.ui.MMAppMgr.Receiver;

class MMAppMgr$Receiver$2 implements Runnable {
    final /* synthetic */ Receiver xJW;

    MMAppMgr$Receiver$2(Receiver receiver) {
        this.xJW = receiver;
    }

    public final void run() {
        MMAppMgr.cnc();
    }
}
