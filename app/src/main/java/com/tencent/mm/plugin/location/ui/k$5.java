package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;

class k$5 implements a {
    final /* synthetic */ k nUL;

    k$5(k kVar) {
        this.nUL = kVar;
    }

    public final boolean uF() {
        int bEV;
        if (this.nUL.nUB == 3) {
            bEV = this.nUL.nUH.bEV();
        } else if (bh.ov(this.nUL.nUy)) {
            return false;
        } else {
            bEV = this.nUL.nUH.bEW();
        }
        k kVar = this.nUL;
        float f = (float) bEV;
        if (f < 10.0f) {
            f = 10.0f;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        VolumeMeter volumeMeter = kVar.nUu;
        f /= 100.0f;
        volumeMeter.nVs = volumeMeter.nVt;
        volumeMeter.nVt = f;
        kVar.nUu.invalidate();
        return true;
    }
}
