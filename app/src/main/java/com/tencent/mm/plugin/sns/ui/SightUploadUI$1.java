package com.tencent.mm.plugin.sns.ui;

import android.widget.LinearLayout.LayoutParams;

class SightUploadUI$1 implements Runnable {
    final /* synthetic */ int rxa;
    final /* synthetic */ SightUploadUI rxb;

    SightUploadUI$1(SightUploadUI sightUploadUI, int i) {
        this.rxb = sightUploadUI;
        this.rxa = i;
    }

    public final void run() {
        SightUploadUI.a(this.rxb).setWidth((int) (((double) this.rxa) * 0.7d));
        SightUploadUI.b(this.rxb).setLayoutParams(new LayoutParams((int) (((double) this.rxa) * 0.3d), SightUploadUI.b(this.rxb).getHeight()));
    }
}
