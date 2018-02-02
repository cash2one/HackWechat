package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;

final class h implements i {
    final MarkerOptions iMn = new MarkerOptions();

    h() {
    }

    public final void f(double d, double d2) {
        this.iMn.position(new LatLng(d, d2));
    }

    public final void p(Bitmap bitmap) {
        this.iMn.icon(new BitmapDescriptor(bitmap));
    }

    public final void T(float f) {
        this.iMn.rotation(f);
    }

    public final void qx(String str) {
        this.iMn.title(str);
    }

    public final void qy(String str) {
        this.iMn.snippet(str);
    }

    public final void bD(View view) {
        this.iMn.markerView(view);
    }

    public final void U(float f) {
        this.iMn.alpha(f);
    }

    public final void p(float f, float f2) {
        this.iMn.anchor(f, f2);
    }

    public final void e(Animation animation) {
        this.iMn.infoWindowShowAnimation(animation);
    }

    public final void f(Animation animation) {
        this.iMn.infoWindowHideAnimation(animation);
    }
}
