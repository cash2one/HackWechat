package com.tencent.mm.plugin.sns.ui;

class e$3 implements Runnable {
    final /* synthetic */ e rqm;
    final /* synthetic */ boolean rqo;

    e$3(e eVar, boolean z) {
        this.rqm = eVar;
        this.rqo = z;
    }

    public final void run() {
        if (this.rqo) {
            e eVar = this.rqm;
            if (eVar.rqk.size() > 1) {
                eVar.rqk.remove(0);
            }
        }
    }
}
