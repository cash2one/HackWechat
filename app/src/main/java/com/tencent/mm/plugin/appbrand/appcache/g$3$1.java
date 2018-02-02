package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.g.3;
import com.tencent.mm.protocal.c.car;

class g$3$1 implements e {
    final /* synthetic */ 3 iDX;

    g$3$1(3 3) {
        this.iDX = 3;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar != null && (kVar.hmG instanceof b)) {
            car com_tencent_mm_protocal_c_car = (car) ((b) kVar.hmG).hmh.hmo;
            int a = g.a(this.iDX.iDU);
            int i3 = com_tencent_mm_protocal_c_car.version;
            aj.b(x.n("@LibraryAppId", a, i3), new 1(this));
        }
        g.Di().gPJ.b(1168, this);
    }
}
