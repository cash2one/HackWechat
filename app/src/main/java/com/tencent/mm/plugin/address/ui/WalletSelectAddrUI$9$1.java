package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.9;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class WalletSelectAddrUI$9$1 implements Runnable {
    final /* synthetic */ 9 ioq;

    WalletSelectAddrUI$9$1(9 9) {
        this.ioq = 9;
    }

    public final void run() {
        if (this.ioq.iop.fAE.fpW) {
            ar.Hg();
            String ou = bh.ou((String) c.CU().get(46, null));
            ar.Hg();
            WalletSelectAddrUI.a(this.ioq.iom, ou, bh.ou((String) c.CU().get(72, null)));
        }
    }
}
