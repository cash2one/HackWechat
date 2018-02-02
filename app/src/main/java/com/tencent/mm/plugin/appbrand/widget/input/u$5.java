package com.tencent.mm.plugin.appbrand.widget.input;

class u$5 implements Runnable {
    final /* synthetic */ u jYI;
    final /* synthetic */ int jYJ;
    final /* synthetic */ boolean jYK;

    u$5(u uVar, int i, boolean z) {
        this.jYI = uVar;
        this.jYJ = i;
        this.jYK = z;
    }

    public final void run() {
        int d = u.d(this.jYI);
        if (this.jYI.isShown()) {
            u.a(this.jYI, this.jYJ);
        } else {
            u.a(this.jYI, 2);
        }
        if (u.e(this.jYI) != null && d != u.d(this.jYI) && !this.jYK) {
            u.e(this.jYI).kf(u.d(this.jYI));
        }
    }
}
