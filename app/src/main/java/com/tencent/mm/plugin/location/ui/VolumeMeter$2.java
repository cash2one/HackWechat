package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.af;

class VolumeMeter$2 implements Runnable {
    final /* synthetic */ VolumeMeter nVG;

    VolumeMeter$2(VolumeMeter volumeMeter) {
        this.nVG = volumeMeter;
    }

    public final void run() {
        VolumeMeter.a(this.nVG, new af());
        this.nVG.aWm();
    }
}
