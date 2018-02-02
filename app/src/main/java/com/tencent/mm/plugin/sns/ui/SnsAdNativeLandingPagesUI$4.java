package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;

class SnsAdNativeLandingPagesUI$4 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$4(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        SnsAdNativeLandingPagesUI.l(this.ryv);
        this.ryv.setRequestedOrientation(1);
        SnsAdNativeLandingPagesUI.bAs();
        ((b) SnsAdNativeLandingPagesUI.f(this.ryv).get(Integer.valueOf(((c) this.ryv.rxB.getFirst()).id))).bxJ();
        SnsAdNativeLandingPagesUI.M(this.ryv);
    }
}
