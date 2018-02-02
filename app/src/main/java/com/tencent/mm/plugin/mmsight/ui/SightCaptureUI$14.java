package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.ui.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$14 implements a {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$14(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void bbe() {
        x.i("MicroMsg.SightCaptureUI", "on video edit finish");
        if (SightCaptureUI.O(this.oDb) != null) {
            SightCaptureUI.O(this.oDb).gJ(false);
            SightCaptureUI.O(this.oDb).release();
            SightCaptureUI.P(this.oDb);
        }
        SightCaptureUI.G(this.oDb).setVisibility(0);
        SightCaptureUI.Q(this.oDb).setVisibility(0);
        SightCaptureUI.R(this.oDb).setVisibility(0);
        SightCaptureUI.S(this.oDb).stop();
        SightCaptureUI.S(this.oDb).setVideoPath(SightCaptureUI.n(this.oDb).getFilePath());
        SightCaptureUI.S(this.oDb);
        SightCaptureUI.S(this.oDb).ccJ();
        SightCaptureUI.S(this.oDb).quG = SightCaptureUI.T(this.oDb);
        this.oDb.DR(8);
        e.post(new 1(this), "SightCaptureUI_edit_finish_save_new_thumb");
        SightCaptureUI.V(this.oDb);
    }

    public final void bbf() {
        x.i("MicroMsg.SightCaptureUI", "on video edit exit");
        if (SightCaptureUI.O(this.oDb) != null) {
            SightCaptureUI.O(this.oDb).gJ(true);
            SightCaptureUI.O(this.oDb).release();
            SightCaptureUI.P(this.oDb);
        }
        this.oDb.DR(8);
        SightCaptureUI.G(this.oDb).setVisibility(0);
        SightCaptureUI.Q(this.oDb).setVisibility(0);
        SightCaptureUI.R(this.oDb).setVisibility(0);
    }

    public final void onError() {
        x.i("MicroMsg.SightCaptureUI", "on video edit error");
        if (SightCaptureUI.O(this.oDb) != null) {
            SightCaptureUI.O(this.oDb).release();
            SightCaptureUI.P(this.oDb);
        }
        ag.y(new 2(this));
    }
}
