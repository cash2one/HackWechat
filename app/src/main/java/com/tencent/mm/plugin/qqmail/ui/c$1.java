package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.g.a.jt;

class c$1 implements Runnable {
    final /* synthetic */ jt iop;
    final /* synthetic */ c ptT;

    c$1(c cVar, jt jtVar) {
        this.ptT = cVar;
        this.iop = jtVar;
    }

    public final void run() {
        if (this.iop.fAE.fpW) {
            c.a(this.ptT);
        } else if (c.b(this.ptT) != null) {
            c.b(this.ptT).bkw();
        }
    }
}
