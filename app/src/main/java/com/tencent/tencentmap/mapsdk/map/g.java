package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class g {
    public static b Aed;
    a AdZ;
    c Aec;
    public e mapContext;

    public interface b {
        void collectErrorInfo(String str);
    }

    public interface g {
    }

    public g(e eVar) {
        this.mapContext = eVar;
        this.AdZ = eVar.e();
        this.Aec = eVar.b();
    }

    public final void a(a aVar) {
        a(aVar, 1000);
    }

    final void a(a aVar, long j) {
        if (!this.mapContext.f().k() || j < 0) {
            aVar.AdW.a(false);
        }
        aVar.AdW.a(null);
        aVar.AdW.a(j);
        this.mapContext.c().a(aVar.AdW);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        return new Circle(this.AdZ.a(circleOptions));
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return new GroundOverlay(this.AdZ.a(groundOverlayOptions));
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        return new Marker(this.AdZ.a(markerOptions));
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        return new Polyline(this.AdZ.a(polylineOptions));
    }

    public final LatLng getMapCenter() {
        return this.Aec.d().getTarget();
    }

    public final int getZoomLevel() {
        return (int) this.Aec.d().getZoom();
    }

    public final void moveCamera(a aVar) {
        if (aVar != null) {
            com.tencent.mapsdk.rastercore.c.a aVar2 = aVar.AdW;
            if (aVar2 != null) {
                aVar2.a(false);
                this.mapContext.c().a(aVar2);
            }
        }
    }
}
