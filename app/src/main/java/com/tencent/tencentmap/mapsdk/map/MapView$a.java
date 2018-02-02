package com.tencent.tencentmap.mapsdk.map;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.f.a;

public class MapView$a extends LayoutParams {
    private int alignment;
    public int mode;
    public LatLng point;
    private int x;
    private int y;

    public MapView$a(int i, int i2, GeoPoint geoPoint, int i3) {
        this(i, i2, geoPoint, i3, (byte) 0);
    }

    private MapView$a(int i, int i2, GeoPoint geoPoint, int i3, byte b) {
        this(i, i2, a.a(geoPoint), 0, 0, i3);
    }

    public MapView$a(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
        super(i, i2);
        this.mode = 1;
        this.alignment = 51;
        this.point = null;
        this.x = 0;
        this.y = 0;
        this.mode = 0;
        this.point = latLng;
        this.x = i3;
        this.y = i4;
        this.alignment = i5;
    }

    protected MapView$a(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.mode = 1;
        this.alignment = 51;
        this.point = null;
        this.x = 0;
        this.y = 0;
    }
}
