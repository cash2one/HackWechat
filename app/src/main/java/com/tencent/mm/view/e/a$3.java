package com.tencent.mm.view.e;

class a$3 implements Runnable {
    final /* synthetic */ String lwx;
    final /* synthetic */ a zGr;

    public a$3(a aVar, String str) {
        this.zGr = aVar;
        this.lwx = str;
    }

    public final void run() {
        if (a.c(this.zGr) != null && a.d(this.zGr) != null && a.d(this.zGr).aas(this.lwx) != null) {
            a.a(this.zGr, a.d(this.zGr).aas(this.lwx).kaM);
            a.c(this.zGr).ah(a.e(this.zGr));
            a.d(this.zGr).zGF = 0;
        }
    }
}
