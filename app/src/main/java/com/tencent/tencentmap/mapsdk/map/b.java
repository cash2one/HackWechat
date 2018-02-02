package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.c.h;
import com.tencent.mapsdk.rastercore.d.a;

public final class b {
    public static a a(LatLng latLng, float f) {
        return new a(a.a(CameraPosition.builder().target(latLng).zoom(f).build()));
    }

    public static a a(LatLngBounds latLngBounds, int i) {
        return new a(a.a(latLngBounds, 0, 0, i));
    }

    public static a aK(float f) {
        com.tencent.mapsdk.rastercore.c.a hVar = new h();
        hVar.a(f);
        return new a(hVar);
    }
}
