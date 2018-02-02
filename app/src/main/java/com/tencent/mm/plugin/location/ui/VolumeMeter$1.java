package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;

class VolumeMeter$1 implements Runnable {
    final /* synthetic */ VolumeMeter nVG;

    VolumeMeter$1(VolumeMeter volumeMeter) {
        this.nVG = volumeMeter;
    }

    public final void run() {
        Looper.prepare();
        VolumeMeter.a(this.nVG, new af());
        Looper.loop();
    }
}
