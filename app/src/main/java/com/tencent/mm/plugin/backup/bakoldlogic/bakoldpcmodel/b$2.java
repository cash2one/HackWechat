package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.f.b;

class b$2 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ int kjb;
    final /* synthetic */ boolean kjd;
    final /* synthetic */ byte[] kje;
    final /* synthetic */ b kqA;

    b$2(b bVar, boolean z, int i, int i2, byte[] bArr) {
        this.kqA = bVar;
        this.kjd = z;
        this.kjb = i;
        this.iGh = i2;
        this.kje = bArr;
    }

    public final void run() {
        b.b(this.kjd, this.kjb, this.iGh, this.kje);
    }
}
