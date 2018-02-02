package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.sdk.platformtools.x;

class LocationWidget$4 implements a {
    final /* synthetic */ LocationWidget rum;

    LocationWidget$4(LocationWidget locationWidget) {
        this.rum = locationWidget;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        x.d("MicroMsg.LocationWidget", "get location %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        e.SS().a(2003, i != 0, LocationWidget.h(this.rum) == null ? false : LocationWidget.h(this.rum).hxP, f, f2, (int) d2);
        o.a(2003, f, f2, 0);
        if (!LocationWidget.e(this.rum)) {
            return false;
        }
        if (LocationWidget.i(this.rum) == -1000.0f || LocationWidget.j(this.rum) == -1000.0f) {
            LocationWidget.a(this.rum, f2);
            LocationWidget.b(this.rum, f);
        }
        return false;
    }
}
