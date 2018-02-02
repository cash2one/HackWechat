package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class d$3 implements Runnable {
    final /* synthetic */ int kly;
    final /* synthetic */ d knU;
    final /* synthetic */ Set knW;

    d$3(d dVar, Set set, int i) {
        this.knU = dVar;
        this.knW = set;
        this.kly = i;
    }

    public final void run() {
        for (c mz : this.knW) {
            mz.mz(this.kly);
        }
    }
}
