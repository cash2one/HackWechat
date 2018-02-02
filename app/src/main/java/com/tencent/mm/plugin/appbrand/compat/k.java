package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.a;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.c;

final class k implements c {
    k() {
    }

    static f d(LatLng latLng) {
        return new 1(latLng);
    }

    static a d(final CameraPosition cameraPosition) {
        return new a() {
        };
    }

    public final b bP(Context context) {
        return new d(context);
    }

    public final b bE(View view) {
        return view == null ? null : (b) view.getTag(R.h.bKr);
    }

    public final f e(double d, double d2) {
        return new f(d, d2);
    }
}
