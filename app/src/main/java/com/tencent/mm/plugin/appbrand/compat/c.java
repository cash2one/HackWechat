package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;

final class c implements com.tencent.mm.plugin.appbrand.compat.a.b.c {
    final CircleOptions iLZ = new CircleOptions();

    c() {
    }

    public final void d(double d, double d2) {
        this.iLZ.center(new LatLng(d, d2));
    }

    public final void jI(int i) {
        this.iLZ.radius((double) i);
    }

    public final void jJ(int i) {
        this.iLZ.strokeColor(i);
    }

    public final void jK(int i) {
        this.iLZ.strokeWidth((float) i);
    }

    public final void jL(int i) {
        this.iLZ.fillColor(i);
    }
}
