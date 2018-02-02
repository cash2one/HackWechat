package com.tencent.mm.plugin.mmsight.segment;

class n$1 implements Runnable {
    final /* synthetic */ int ozs;
    final /* synthetic */ int ozt;
    final /* synthetic */ int ozu;
    final /* synthetic */ n ozv;

    n$1(n nVar, int i, int i2, int i3) {
        this.ozv = nVar;
        this.ozs = i;
        this.ozt = i2;
        this.ozu = i3;
    }

    public final void run() {
        if (this.ozs <= n.a(this.ozv) * 2) {
            throw new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
        }
        n.b(this.ozv);
        n.a(this.ozv, this.ozt);
        n.b(this.ozv, Math.min(this.ozs, this.ozv.getWidth() - (this.ozt * 2)));
        n.c(this.ozv, Math.max(this.ozu, n.a(this.ozv) * 2));
        n.c(this.ozv).setBounds(this.ozt, 0, this.ozt + n.a(this.ozv), this.ozv.getHeight());
        n.e(this.ozv).setBounds((this.ozt + n.d(this.ozv)) - n.a(this.ozv), 0, n.d(this.ozv) + this.ozt, this.ozv.getHeight());
        if (n.f(this.ozv) == null && n.g(this.ozv) == null) {
            n.a(this.ozv, n.c(this.ozv).getBounds());
            n.b(this.ozv, n.e(this.ozv).getBounds());
        }
        this.ozv.invalidate();
    }
}
