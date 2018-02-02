package com.tencent.mm.plugin.backup.bakoldlogic.d;

class a$1 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ Object kpI;
    final /* synthetic */ a ksf;

    a$1(a aVar, int i, Object obj) {
        this.ksf = aVar;
        this.iGh = i;
        this.kpI = obj;
    }

    public final void run() {
        this.ksf.kpH.add(new a$a(this.ksf, this.iGh, this.kpI));
    }
}
