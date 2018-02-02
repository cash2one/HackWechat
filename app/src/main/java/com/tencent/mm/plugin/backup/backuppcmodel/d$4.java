package com.tencent.mm.plugin.backup.backuppcmodel;

class d$4 implements Runnable {
    final /* synthetic */ int kly;
    final /* synthetic */ d knU;

    d$4(d dVar, int i) {
        this.knU = dVar;
        this.kly = i;
    }

    public final void run() {
        if (d.d(this.knU) != null) {
            d.d(this.knU).my(this.kly);
        }
    }
}
