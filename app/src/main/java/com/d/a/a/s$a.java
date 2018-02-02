package com.d.a.a;

class s$a implements Runnable {
    final int bjj;
    final float bkg;
    final float bkh;
    final String bki;
    final /* synthetic */ s bkj;
    final float x;
    final float y;

    private s$a(s sVar, float f, float f2, float f3, float f4, int i, String str) {
        this.bkj = sVar;
        this.x = f;
        this.y = f2;
        this.bkg = f3;
        this.bkh = f4;
        this.bjj = i;
        this.bki = str;
    }

    public final void run() {
        this.bkj.a(this.x, this.y, this.bkg, this.bkh, this.bjj, this.bki);
    }
}
