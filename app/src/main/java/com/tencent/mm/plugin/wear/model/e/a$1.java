package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;

class a$1 implements Runnable {
    final /* synthetic */ byte[] tiL;
    final /* synthetic */ a tiM;

    a$1(a aVar, byte[] bArr) {
        this.tiM = aVar;
        this.tiL = bArr;
    }

    public final void run() {
        a.bOt().thH.aV(this.tiL);
    }
}
