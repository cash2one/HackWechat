package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

class b$3 implements Runnable {
    final /* synthetic */ byte[] fgL;
    final /* synthetic */ int kjb;
    final /* synthetic */ b kqA;

    b$3(b bVar, int i, byte[] bArr) {
        this.kqA = bVar;
        this.kjb = i;
        this.fgL = bArr;
    }

    public final void run() {
        this.kqA.Z(this.fgL);
    }
}
