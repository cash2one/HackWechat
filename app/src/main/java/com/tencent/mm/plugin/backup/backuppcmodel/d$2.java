package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.a.b.c;
import java.util.Set;

class d$2 implements Runnable {
    final /* synthetic */ d knU;
    final /* synthetic */ Set knW;

    d$2(d dVar, Set set) {
        this.knU = dVar;
        this.knW = set;
    }

    public final void run() {
        for (c aoj : this.knW) {
            aoj.aoj();
        }
    }
}
