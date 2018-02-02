package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.z.ar;

class a$a implements Runnable {
    final /* synthetic */ a nEi;
    private b nEj = null;

    public a$a(a aVar, b bVar) {
        this.nEi = aVar;
        this.nEj = bVar;
    }

    public final void run() {
        if (this.nEj != null) {
            this.nEj.bGf();
            this.nEj.bGc();
            this.nEj = null;
            this.nEi.nEh = false;
        }
        ar.Hh().setMode(0);
    }
}
