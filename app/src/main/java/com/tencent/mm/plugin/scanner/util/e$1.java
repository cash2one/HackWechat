package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.g.a.lm;

class e$1 implements Runnable {
    final /* synthetic */ lm qaa;
    final /* synthetic */ e qab;

    e$1(e eVar, lm lmVar) {
        this.qab = eVar;
        this.qaa = lmVar;
    }

    public final void run() {
        if (this.qab.getContext() != null && this.qaa.fCQ != null) {
            if (this.qaa.fCQ.ret == 1) {
                this.qab.hs(true);
            } else if (this.qaa.fCQ.ret == 2) {
                this.qab.hs(false);
            }
        }
    }
}
