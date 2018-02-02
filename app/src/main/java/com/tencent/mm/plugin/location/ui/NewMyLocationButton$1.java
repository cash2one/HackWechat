package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.af;

class NewMyLocationButton$1 implements a {
    final /* synthetic */ NewMyLocationButton nTi;

    NewMyLocationButton$1(NewMyLocationButton newMyLocationButton) {
        this.nTi = newMyLocationButton;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        NewMyLocationButton.a(this.nTi).setVisibility(8);
        NewMyLocationButton.b(this.nTi).setVisibility(0);
        if (NewMyLocationButton.c(this.nTi) != null && NewMyLocationButton.d(this.nTi)) {
            NewMyLocationButton.c(this.nTi).getIController().setCenter((double) f2, (double) f);
            if (NewMyLocationButton.c(this.nTi).getZoomLevel() < 16) {
                NewMyLocationButton.c(this.nTi).getIController().setZoom(16);
            }
        }
        new af(Looper.getMainLooper()).post(new 1(this));
        return false;
    }
}
