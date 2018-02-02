package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.af;

class MyLocationButton$1 implements a {
    final /* synthetic */ MyLocationButton nSN;

    MyLocationButton$1(MyLocationButton myLocationButton) {
        this.nSN = myLocationButton;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        MyLocationButton.a(this.nSN).setVisibility(8);
        MyLocationButton.b(this.nSN).setVisibility(0);
        if (MyLocationButton.c(this.nSN) != null && MyLocationButton.d(this.nSN)) {
            MyLocationButton.c(this.nSN).getIController().setCenter((double) f2, (double) f);
            if (MyLocationButton.c(this.nSN).getZoomLevel() < 16) {
                MyLocationButton.c(this.nSN).getIController().setZoom(16);
            }
        }
        new af(Looper.getMainLooper()).post(new 1(this));
        return false;
    }
}
