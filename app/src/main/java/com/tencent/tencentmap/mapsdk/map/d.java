package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.d.a;

public final class d {
    private boolean AdX = true;
    public MapView AdY;

    public d(MapView mapView) {
        this.AdY = mapView;
    }

    public final void b(GeoPoint geoPoint) {
        this.AdY.getMap().a(new a(a.a(CameraPosition.builder().target(com.tencent.mapsdk.rastercore.f.a.a(geoPoint)).build())), 1000);
    }

    public final void c(GeoPoint geoPoint) {
        g map = this.AdY.getMap();
        map.a(b.a(com.tencent.mapsdk.rastercore.f.a.a(geoPoint), (float) map.getZoomLevel()), 0);
    }

    public final void setZoom(int i) {
        this.AdY.getMap().a(b.aK((float) i), 0);
    }
}
