package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.f.b;

class a$5 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ a kja;
    final /* synthetic */ int kjb;
    final /* synthetic */ boolean kjd;
    final /* synthetic */ byte[] kje;

    a$5(a aVar, boolean z, int i, int i2, byte[] bArr) {
        this.kja = aVar;
        this.kjd = z;
        this.kjb = i;
        this.iGh = i2;
        this.kje = bArr;
    }

    public final void run() {
        b.b(this.kjd, this.kjb, this.iGh, this.kje);
    }
}
