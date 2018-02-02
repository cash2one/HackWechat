package com.tencent.mm.plugin.shake.c.b;

import com.tencent.mm.g.a.oz;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ a qpf;
    final /* synthetic */ oz qpg;

    a$3(a aVar, oz ozVar) {
        this.qpf = aVar;
        this.qpg = ozVar;
    }

    public final void run() {
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
        a.a(this.qpf, this.qpg.fGT);
        if (a.g(this.qpf) != null) {
            a.b(this.qpf, 8);
            if (a.g(this.qpf) != null) {
                a.a(this.qpf, a.g(this.qpf).fGU);
            }
            if (a.g(this.qpf) == null || !a.g(this.qpf).fsH) {
                a.a(this.qpf, a$a.qpk);
                a.h(this.qpf);
                a.k(this.qpf);
                return;
            }
            a.a(this.qpf, a$a.qpj);
            a.h(this.qpf);
            a.i(this.qpf);
            a.j(this.qpf);
            if (a.a(this.qpf) != null) {
                a.a(this.qpf).brR();
                return;
            }
            return;
        }
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
    }
}
