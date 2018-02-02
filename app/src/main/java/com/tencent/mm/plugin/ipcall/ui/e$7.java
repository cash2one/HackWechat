package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.sdk.platformtools.bh;

class e$7 implements Runnable {
    final /* synthetic */ e nIr;

    e$7(e eVar) {
        this.nIr = eVar;
    }

    public final void run() {
        aid aUQ = c.aUQ();
        if (aUQ != null) {
            this.nIr.nIm.setText(aUQ.wpu);
            if (bh.ov(aUQ.wpC)) {
                this.nIr.nIn.setText("");
                this.nIr.nIn.setVisibility(8);
                return;
            }
            this.nIr.nIn.setText(aUQ.wpC);
            this.nIr.nIn.setVisibility(0);
            return;
        }
        this.nIr.nIm.setText("");
        this.nIr.nIn.setText("");
        this.nIr.nIn.setVisibility(8);
    }
}
