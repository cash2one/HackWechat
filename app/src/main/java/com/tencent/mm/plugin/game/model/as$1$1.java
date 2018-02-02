package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.plugin.game.model.as.1;

class as$1$1 implements Runnable {
    final /* synthetic */ bp new;
    final /* synthetic */ 1 nex;

    as$1$1(1 1, bp bpVar) {
        this.nex = 1;
        this.new = bpVar;
    }

    public final void run() {
        as.a(this.new);
        if (this.nex.nev != null) {
            this.nex.nev.b(this.new);
        }
    }
}
