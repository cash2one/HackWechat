package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.7;
import com.tencent.mm.sdk.platformtools.x;

class IPCallMsgUI$7$1 implements Runnable {
    final /* synthetic */ 7 nKL;

    IPCallMsgUI$7$1(7 7) {
        this.nKL = 7;
    }

    public final void run() {
        synchronized (this.nKL.nKK.nKH) {
            x.v("MicroMsg.IPCallMsgUI", "comment notify");
            this.nKL.nKK.nKH.a(null, null);
        }
    }
}
