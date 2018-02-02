package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.compatible.d.m;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;

class SightCaptureUI$10 implements Runnable {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$10(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void run() {
        String Ff = d.Ff(SightCaptureUI.n(this.oDb).getFilePath());
        if (!bh.ov(Ff)) {
            ag.y(new 1(this, ((Ff + "\n" + String.format("FPS: %s", new Object[]{Float.valueOf(SightCaptureUI.n(this.oDb).baw())})) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(d.Fh("TIME_RECODER_2_PLAY"))})) + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.ys(), m.yq()})));
        }
    }
}
