package com.tencent.mapsdk.rastercore.e.a;

import com.tencent.mapsdk.rastercore.e.a.c.4;

class c$4$1 implements Runnable {
    private /* synthetic */ 4 a;

    c$4$1(4 4) {
        this.a = 4;
    }

    public final void run() {
        c.d(this.a.b).removeView(c.j(this.a.b));
        c.k(this.a.b).setAnimationListener(null);
        c.a(this.a.b, this.a.a);
        c.l(this.a.b);
        c.m(this.a.b);
    }
}
