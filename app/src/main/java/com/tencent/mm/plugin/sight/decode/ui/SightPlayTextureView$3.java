package com.tencent.mm.plugin.sight.decode.ui;

import android.view.ViewGroup.LayoutParams;

class SightPlayTextureView$3 implements Runnable {
    final /* synthetic */ LayoutParams quL;
    final /* synthetic */ SightPlayTextureView quO;

    SightPlayTextureView$3(SightPlayTextureView sightPlayTextureView, LayoutParams layoutParams) {
        this.quO = sightPlayTextureView;
        this.quL = layoutParams;
    }

    public final void run() {
        this.quO.setLayoutParams(this.quL);
    }
}
