package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;

class f$2 implements Runnable {
    final /* synthetic */ f mBc;
    final /* synthetic */ Activity oZ;

    f$2(f fVar, Activity activity) {
        this.mBc = fVar;
        this.oZ = activity;
    }

    public final void run() {
        this.oZ.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this.mBc);
        this.oZ.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(this.mBc);
    }
}
