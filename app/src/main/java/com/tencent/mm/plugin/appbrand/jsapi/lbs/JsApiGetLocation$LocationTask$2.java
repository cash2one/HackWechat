package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.JsApiGetLocation.LocationTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetLocation$LocationTask$2 implements a {
    final /* synthetic */ LocationTask jkB;

    JsApiGetLocation$LocationTask$2(LocationTask locationTask) {
        this.jkB = locationTask;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        x.v("MicroMsg.JsApiGetLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f, altitude : %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)});
        LocationTask.b(this.jkB, true);
        LocationTask.a(this.jkB, f2);
        LocationTask.b(this.jkB, f);
        LocationTask locationTask = this.jkB;
        if (d == 0.0d) {
            d = -1.0d;
        }
        LocationTask.a(locationTask, d);
        LocationTask.b(this.jkB, d2);
        LocationTask.c(this.jkB, d3);
        LocationTask.c(this.jkB);
        LocationTask.d(this.jkB, d2);
        LocationTask.b(this.jkB, i);
        if (d3 == 0.0d && LocationTask.d(this.jkB)) {
            g.Dm().g(new 1(this), 5000);
            x.i("MicroMsg.JsApiGetLocation", "post delay 5 sec.");
        } else {
            x.i("MicroMsg.JsApiGetLocation", "Stop callback");
            LocationTask.e(this.jkB);
            LocationTask.f(this.jkB);
        }
        return false;
    }
}
