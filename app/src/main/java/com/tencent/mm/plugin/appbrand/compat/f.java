package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;

final class f implements com.tencent.mm.plugin.appbrand.compat.a.b.f {
    final LatLng iMk;

    public final double abC() {
        return this.iMk.getLatitude();
    }

    public final double abD() {
        return this.iMk.getLongitude();
    }

    f(double d, double d2) {
        this.iMk = new LatLng(d, d2);
    }

    f(LatLng latLng) {
        if (latLng != null) {
            this.iMk = latLng;
        } else {
            this.iMk = new LatLng(0.0d, 0.0d);
        }
    }

    static LatLng a(com.tencent.mm.plugin.appbrand.compat.a.b.f fVar) {
        if (fVar instanceof f) {
            return ((f) fVar).iMk;
        }
        return new LatLng(fVar.abC(), fVar.abD());
    }
}
