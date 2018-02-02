package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class SnsAdNativeLandingPagesUI$2 implements OnLayoutChangeListener {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$2(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (SnsAdNativeLandingPagesUI.C(this.ryv).getHeight() == SnsAdNativeLandingPagesUI.D(this.ryv)) {
            SnsAdNativeLandingPagesUI.C(this.ryv).removeOnLayoutChangeListener(this);
            SnsAdNativeLandingPagesUI.c(this.ryv);
            SnsAdNativeLandingPagesUI.d(this.ryv);
        }
    }
}
