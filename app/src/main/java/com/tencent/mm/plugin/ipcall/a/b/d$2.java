package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements a {
    final /* synthetic */ d nEE;
    final /* synthetic */ boolean nEF;

    d$2(d dVar, boolean z) {
        this.nEE = dVar;
        this.nEF = z;
    }

    public final boolean uF() {
        if (this.nEF) {
            x.i("MicroMsg.IPCallSensorManager", "light screen");
            if (this.nEE.nED != null) {
                this.nEE.nED.fX(false);
            }
        } else {
            x.i("MicroMsg.IPCallSensorManager", "off screen");
            if (this.nEE.nED != null) {
                this.nEE.nED.fX(true);
            }
        }
        return false;
    }
}
