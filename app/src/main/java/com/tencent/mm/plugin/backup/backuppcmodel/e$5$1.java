package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.backuppcmodel.e.5;
import java.util.Set;

class e$5$1 implements Runnable {
    final /* synthetic */ int kly;
    final /* synthetic */ Set knW;
    final /* synthetic */ 5 koe;

    e$5$1(5 5, Set set, int i) {
        this.koe = 5;
        this.knW = set;
        this.kly = i;
    }

    public final void run() {
        for (c mz : this.knW) {
            mz.mz(this.kly);
        }
    }
}
