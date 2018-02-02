package com.tencent.mapsdk.rastercore.e.a;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.rastercore.e.a.c.7;
import com.tencent.tencentmap.mapsdk.map.g.a;

class c$7$1 implements Runnable {
    private /* synthetic */ 7 a;

    c$7$1(7 7) {
        this.a = 7;
    }

    public final void run() {
        c.d(this.a.a).removeView(c.n(this.a.a));
        if (c.a(this.a.a).g() != null) {
            a g = c.o(this.a.a).h().g();
            Marker marker = new Marker(this.a.a);
            c.n(this.a.a);
            g.d(marker);
        }
        c.b(this.a.a, null);
    }
}
