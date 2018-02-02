package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ad$9 implements b {
    final /* synthetic */ ad lNY;

    ad$9(ad adVar) {
        this.lNY = adVar;
    }

    public final void a(int i, m mVar, Object obj) {
        try {
            if (!ar.Hj()) {
                x.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
            } else if (obj instanceof String) {
                ar.Dm().g(new 1(this, obj), 2000);
            }
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[]{e.getMessage()});
        }
    }
}
