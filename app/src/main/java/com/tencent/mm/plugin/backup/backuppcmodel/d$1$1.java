package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.plugin.backup.backuppcmodel.d.1;

class d$1$1 implements Runnable {
    final /* synthetic */ int iGh;
    final /* synthetic */ int kjb;
    final /* synthetic */ byte[] kje;
    final /* synthetic */ 1 knV;

    d$1$1(1 1, int i, byte[] bArr, int i2) {
        this.knV = 1;
        this.iGh = i;
        this.kje = bArr;
        this.kjb = i2;
    }

    public final void run() {
        if (this.iGh == 3) {
            d.a(this.knV.knU, this.kje, this.kjb);
        } else if (this.iGh == 11) {
            d.b(this.knV.knU, this.kje, this.kjb);
        } else if (this.iGh == 6) {
            d.c(this.knV.knU, this.kje, this.kjb);
        } else if (this.iGh == 13) {
            d.E(this.kje, this.kjb);
        } else if (this.iGh == 15) {
            d.d(this.knV.knU, this.kje, this.kjb);
        } else if (this.iGh == 8) {
            d.a(this.knV.knU, this.kje);
        }
    }
}
