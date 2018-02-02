package com.tencent.mm.plugin.backup.g;

class a$1 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ Object kpI;
    final /* synthetic */ a kpJ;

    a$1(a aVar, int i, Object obj) {
        this.kpJ = aVar;
        this.iGh = i;
        this.kpI = obj;
    }

    public final void run() {
        this.kpJ.kpH.add(new a$a(this.kpJ, this.iGh, this.kpI));
    }
}
