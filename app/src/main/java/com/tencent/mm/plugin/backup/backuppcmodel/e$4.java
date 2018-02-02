package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class e$4 implements Runnable {
    final /* synthetic */ Set knW;
    final /* synthetic */ e koc;

    e$4(e eVar, Set set) {
        this.koc = eVar;
        this.knW = set;
    }

    public final void run() {
        for (c aoj : this.knW) {
            aoj.aoj();
        }
    }
}
