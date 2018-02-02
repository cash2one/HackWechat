package com.tencent.mapsdk.rastercore.e.a;

import com.tencent.mapsdk.rastercore.e.a.c.5;

class c$5$1 implements Runnable {
    private /* synthetic */ 5 a;

    c$5$1(5 5) {
        this.a = 5;
    }

    public final void run() {
        c.d(this.a.a).removeView(c.j(this.a.a));
        c.d(this.a.a).removeView(c.n(this.a.a));
        c.k(this.a.a).setAnimationListener(null);
    }
}
