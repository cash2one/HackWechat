package com.tencent.mm.plugin.offline;

class i$2 implements Runnable {
    final /* synthetic */ i oVU;
    final /* synthetic */ int oVV;
    final /* synthetic */ int oVW;

    i$2(i iVar, int i, int i2) {
        this.oVU = iVar;
        this.oVV = i;
        this.oVW = i2;
    }

    public final void run() {
        this.oVU.de(this.oVV, this.oVW);
    }
}
