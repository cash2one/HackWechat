package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mm.plugin.appbrand.compat.a.b$r;
import com.tencent.mm.plugin.appbrand.compat.a.b.g;

final class l implements b$r {
    final VisibleRegion iMs;

    l(VisibleRegion visibleRegion) {
        this.iMs = visibleRegion;
    }

    public final g abG() {
        return new e(this.iMs.getLatLngBounds());
    }
}
