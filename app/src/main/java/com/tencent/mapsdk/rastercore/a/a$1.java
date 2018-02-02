package com.tencent.mapsdk.rastercore.a;

class a$1 implements Runnable {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (a.a(this.a).computeScrollOffset()) {
            float currX = (((float) a.a(this.a).getCurrX()) * 1.0f) / 10000.0f;
            float b = currX - a.b(this.a);
            a.a(this.a, a.c(this.a) + ((double) b));
            if (a.c(this.a) < 1.0d) {
                this.a.a(b);
            }
            a.a(this.a, currX);
            if (a.d(this.a)) {
                a.f(this.a).postDelayed(a.e(this.a), 5);
            }
            this.a.a.h().a(false);
            return;
        }
        this.a.d();
        if (this.a.c != null) {
            this.a.c.onFinish();
        }
        a.a(this.a, false);
        this.a.a.h().a(true);
    }
}
