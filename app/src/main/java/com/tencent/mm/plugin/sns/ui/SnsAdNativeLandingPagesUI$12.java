package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a;

class SnsAdNativeLandingPagesUI$12 implements a {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$12(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void o(b bVar) {
        RecyclerView bxG = bVar.bxG();
        if (bxG != null) {
            bxG.getViewTreeObserver().addOnPreDrawListener(new 1(this, bxG));
        }
    }
}
