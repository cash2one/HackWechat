package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.tencentmap.mapsdk.map.g.c;

class d$4 implements c {
    final /* synthetic */ d iMd;
    final /* synthetic */ j iMg;

    d$4(d dVar, j jVar) {
        this.iMd = dVar;
        this.iMg = jVar;
    }

    public final void a(Marker marker) {
        if (this.iMg != null) {
            this.iMg.b(new g(marker));
        }
    }
}
