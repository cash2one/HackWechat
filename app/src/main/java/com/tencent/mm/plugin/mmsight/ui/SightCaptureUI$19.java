package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$19 implements f$a {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$19(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", new Object[]{Integer.valueOf(this.oDb.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void hX() {
        if (SightCaptureUI.S(this.oDb) != null) {
            SightCaptureUI.S(this.oDb).start();
            SightCaptureUI.S(this.oDb);
        }
        ag.K(SightCaptureUI.M(this.oDb));
        SightCaptureUI.S(this.oDb).vyk = new 1(this);
    }

    public final void vh() {
        SightCaptureUI.S(this.oDb).c(0.0d, true);
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}
