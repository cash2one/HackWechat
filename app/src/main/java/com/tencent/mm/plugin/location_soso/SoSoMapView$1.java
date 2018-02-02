package com.tencent.mm.plugin.location_soso;

import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sdk.platformtools.x;

class SoSoMapView$1 implements b {
    final /* synthetic */ SoSoMapView this$0;

    SoSoMapView$1(SoSoMapView soSoMapView) {
        this.this$0 = soSoMapView;
    }

    public void setZoom(int i) {
        x.d(SoSoMapView.TAG, "set Zoom %d", new Object[]{Integer.valueOf(i)});
        this.this$0.getController().setZoom(i);
    }

    public void animateTo(double d, double d2, int i) {
        x.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2 + " zoom:" + i);
        if (SoSoMapView.access$000(this.this$0)) {
            this.this$0.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
        } else {
            this.this$0.getController().b(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
        }
        SoSoMapView.access$002(this.this$0, false);
        this.this$0.getController().setZoom(i);
    }

    public void animateTo(double d, double d2) {
        x.d(SoSoMapView.TAG, "animteTo slat:" + d + " slong:" + d2);
        if (SoSoMapView.access$000(this.this$0)) {
            this.this$0.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
        } else {
            this.this$0.getController().b(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
        }
        SoSoMapView.access$002(this.this$0, false);
    }

    public void setCenter(double d, double d2) {
        this.this$0.getController().c(new GeoPoint((int) (d * 1000000.0d), (int) (1000000.0d * d2)));
    }

    public void offsetCenter(double d, double d2) {
        setCenter((((double) this.this$0.getMapCenterX()) / 1000000.0d) + d, (((double) this.this$0.getMapCenterY()) / 1000000.0d) + d2);
    }
}
