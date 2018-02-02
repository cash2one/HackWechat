package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;
import com.tencent.mm.plugin.appbrand.compat.a.b.g;

final class e implements g {
    final LatLngBounds iMj;

    e(LatLngBounds latLngBounds) {
        this.iMj = latLngBounds;
    }

    public final b$f abA() {
        LatLng southwest = this.iMj.getSouthwest();
        return new f(southwest.getLatitude(), southwest.getLongitude());
    }

    public final b$f abB() {
        LatLng northeast = this.iMj.getNortheast();
        return new f(northeast.getLatitude(), northeast.getLongitude());
    }
}
