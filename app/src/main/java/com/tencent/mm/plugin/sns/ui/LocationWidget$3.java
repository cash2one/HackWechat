package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class LocationWidget$3 implements a {
    final /* synthetic */ LocationWidget rum;

    LocationWidget$3(LocationWidget locationWidget) {
        this.rum = locationWidget;
    }

    public final void b(Addr addr) {
        x.i("MicroMsg.LocationWidget", "get info %s", new Object[]{addr.toString()});
        if (LocationWidget.e(this.rum)) {
            LocationWidget.f(this.rum);
            if (bh.ov(LocationWidget.g(this.rum))) {
                LocationWidget.a(this.rum, addr.hxw);
                LocationWidget.f(this.rum);
            }
        }
    }
}
