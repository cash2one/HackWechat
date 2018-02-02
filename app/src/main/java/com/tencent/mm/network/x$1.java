package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;

class x$1 implements Runnable {
    final /* synthetic */ String iaA;
    final /* synthetic */ boolean iaB;
    final /* synthetic */ x iaC;
    final /* synthetic */ boolean iay;
    final /* synthetic */ long iaz;

    x$1(x xVar, boolean z, long j, String str, boolean z2) {
        this.iaC = xVar;
        this.iay = z;
        this.iaz = j;
        this.iaA = str;
        this.iaB = z2;
    }

    public final void run() {
        if (this.iay) {
            SmcLogic.writeImportKvData(this.iaz, this.iaA, this.iaB);
        } else {
            SmcLogic.writeKvData(this.iaz, this.iaA, this.iaB);
        }
    }

    public final String toString() {
        return super.toString() + "|reportKV";
    }
}
