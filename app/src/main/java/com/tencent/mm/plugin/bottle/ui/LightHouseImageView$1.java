package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;

class LightHouseImageView$1 implements Runnable {
    final /* synthetic */ int aar;
    final /* synthetic */ LightHouseImageView kCA;

    LightHouseImageView$1(LightHouseImageView lightHouseImageView, int i) {
        this.kCA = lightHouseImageView;
        this.aar = i;
    }

    public final void run() {
        LightHouseImageView.a(this.kCA, this.aar);
        LightHouseImageView.a(this.kCA, (AnimationDrawable) this.kCA.getBackground());
        LightHouseImageView.a(this.kCA);
        LightHouseImageView.b(this.kCA).start();
    }
}
