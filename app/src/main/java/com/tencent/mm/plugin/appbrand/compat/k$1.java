package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;

class k$1 implements b$f {
    final /* synthetic */ LatLng iMq;

    k$1(LatLng latLng) {
        this.iMq = latLng;
    }

    public final double abC() {
        return this.iMq.getLatitude();
    }

    public final double abD() {
        return this.iMq.getLongitude();
    }

    public final String toString() {
        return "lat/lng: (" + this.iMq.getLatitude() + "," + this.iMq.getLongitude() + ")";
    }
}
