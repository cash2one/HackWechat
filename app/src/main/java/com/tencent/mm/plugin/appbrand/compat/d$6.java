package com.tencent.mm.plugin.appbrand.compat;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.tencentmap.mapsdk.map.g.a;

class d$6 implements a {
    final /* synthetic */ d iMd;
    final /* synthetic */ e iMi;

    d$6(d dVar, e eVar) {
        this.iMd = dVar;
        this.iMi = eVar;
    }

    public final View c(Marker marker) {
        return this.iMi.a(new g(marker));
    }

    public final void d(Marker marker) {
        g gVar = new g(marker);
    }
}
