package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.f.b;

class c$5 implements Runnable {
    final /* synthetic */ c knN;

    c$5(c cVar) {
        this.knN = cVar;
    }

    public final void run() {
        b.aps().aoS().stop();
        b.aps().aon();
        b.apK();
        b.apM();
    }
}
