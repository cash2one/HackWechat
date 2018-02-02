package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements Runnable {
    final /* synthetic */ c nCj;

    c$3(c cVar) {
        this.nCj = cVar;
    }

    public final void run() {
        if (!i.aTB().aTu()) {
            x.i("MicroMsg.IPCallManager", "timeout! still not accept!");
            if (this.nCj.cI(9, 12)) {
                this.nCj.d(9, null, ac.getContext().getString(R.l.dNm), 2);
            }
        }
    }
}
