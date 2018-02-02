package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class SightCameraView$1 implements a {
    final /* synthetic */ SightCameraView qxJ;

    SightCameraView$1(SightCameraView sightCameraView) {
        this.qxJ = sightCameraView;
    }

    public final boolean uF() {
        float btr = ((float) this.qxJ.qxy.btr()) / ((float) this.qxJ.qxE);
        if (Float.compare(btr, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.a(this.qxJ) <= 20000) {
            if (Float.compare(btr, 1.0f) <= 0 || this.qxJ.qxy.bts() != com.tencent.mm.plugin.sight.encode.a.a.a.qwf) {
                this.qxJ.au(btr);
            } else if (!this.qxJ.qxy.btq()) {
                SightCameraView.b(this.qxJ);
            }
            return true;
        }
        x.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[]{Long.valueOf(20000)});
        this.qxJ.aHv();
        return false;
    }
}
