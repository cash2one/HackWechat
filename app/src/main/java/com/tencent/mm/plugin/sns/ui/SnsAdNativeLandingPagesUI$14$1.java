package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.14;
import com.tencent.mm.sdk.platformtools.ag;

class SnsAdNativeLandingPagesUI$14$1 implements Runnable {
    final /* synthetic */ Object jby;
    final /* synthetic */ 14 ryC;

    SnsAdNativeLandingPagesUI$14$1(14 14, Object obj) {
        this.ryC = 14;
        this.jby = obj;
    }

    public final void run() {
        this.ryC.ryv.rxB = e.c(SnsAdNativeLandingPagesUI.h(this.ryC.ryv), SnsAdNativeLandingPagesUI.i(this.ryC.ryv), (String) this.jby, SnsAdNativeLandingPagesUI.j(this.ryC.ryv), SnsAdNativeLandingPagesUI.k(this.ryC.ryv));
        ag.y(new 1(this));
    }
}
