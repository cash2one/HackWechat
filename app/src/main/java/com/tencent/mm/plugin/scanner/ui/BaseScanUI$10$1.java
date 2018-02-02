package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI.10;
import com.tencent.mm.plugin.scanner.util.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class BaseScanUI$10$1 implements c {
    final /* synthetic */ 10 pUW;

    BaseScanUI$10$1(10 10) {
        this.pUW = 10;
    }

    public final void a(n nVar) {
        nVar.eQ(0, R.l.dCx);
        if (this.pUW.pUV != null) {
            nVar.eQ(1, R.l.eJx);
        }
        if (i.bpK()) {
            nVar.eQ(2, R.l.eHE);
            x.i("MicroMsg.scanner.BaseScanUI", "show history list");
        }
    }
}
