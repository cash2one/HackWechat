package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ag;

class b$1 implements Runnable {
    final /* synthetic */ b nHy;

    b$1(b bVar) {
        this.nHy = bVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.nHy.nHr >= 500) {
            this.nHy.nHp = a.ak(this.nHy.fmM, this.nHy.nHn + this.nHy.nHo);
            ag.y(new 1(this, i.aTD().CD(this.nHy.nHp)));
            return;
        }
        ag.y(new 2(this));
    }
}
