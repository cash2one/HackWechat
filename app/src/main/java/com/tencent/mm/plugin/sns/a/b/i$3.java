package com.tencent.mm.plugin.sns.a.b;

class i$3 implements Runnable {
    final /* synthetic */ i qPK;

    i$3(i iVar) {
        this.qPK = iVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - i.b(this.qPK) >= 60000 || i.a(this.qPK).vGC.size() > 1000) {
            if (i.a(this.qPK) != null && i.a(this.qPK).vGC.size() > 0) {
                i.d(this.qPK);
            }
            i.a(this.qPK, 0);
        }
    }
}
