package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class f {
    public c Aec;
    private e mapContext;

    public f(e eVar) {
        this.mapContext = eVar;
        this.Aec = eVar.b();
    }

    private LatLng h(Point point) {
        return this.Aec.a(point.x, point.y);
    }

    public final VisibleRegion cGo() {
        int width = this.mapContext.c().getWidth();
        int height = this.mapContext.c().getHeight();
        LatLng h = h(new Point(0, 0));
        LatLng h2 = h(new Point(width, 0));
        LatLng h3 = h(new Point(0, height));
        LatLng h4 = h(new Point(width, height));
        return new VisibleRegion(h3, h4, h, h2, LatLngBounds.builder().include(h3).include(h4).include(h).include(h2).build());
    }
}
