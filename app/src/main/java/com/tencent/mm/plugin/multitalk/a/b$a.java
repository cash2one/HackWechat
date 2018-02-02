package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.z.ar;

class b$a implements Runnable {
    private b nEj = null;
    final /* synthetic */ b oFP;

    public b$a(b bVar, b bVar2) {
        this.oFP = bVar;
        this.nEj = bVar2;
    }

    public final void run() {
        if (this.nEj != null) {
            this.nEj.bGf();
            this.nEj.bGc();
            this.nEj = null;
            ar.Hh().xV();
            ar.Hh().setMode(0);
        }
    }
}
