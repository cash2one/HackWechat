package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.backuppcmodel.e.5;

class e$5$2 implements Runnable {
    final /* synthetic */ int kly;
    final /* synthetic */ 5 koe;

    e$5$2(5 5, int i) {
        this.koe = 5;
        this.kly = i;
    }

    public final void run() {
        if (e.e(this.koe.koc) != null) {
            e.e(this.koe.koc).my(this.kly);
        }
    }
}
