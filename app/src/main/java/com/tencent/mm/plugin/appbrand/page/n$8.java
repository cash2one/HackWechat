package com.tencent.mm.plugin.appbrand.page;

class n$8 implements Runnable {
    final /* synthetic */ n jDp;
    final /* synthetic */ String jDx;
    final /* synthetic */ String jDy;
    final /* synthetic */ int[] jDz;

    n$8(n nVar, String str, String str2, int[] iArr) {
        this.jDp = nVar;
        this.jDx = str;
        this.jDy = str2;
        this.jDz = iArr;
    }

    public final void run() {
        n.a(this.jDp, this.jDx, this.jDy, this.jDz);
    }
}
