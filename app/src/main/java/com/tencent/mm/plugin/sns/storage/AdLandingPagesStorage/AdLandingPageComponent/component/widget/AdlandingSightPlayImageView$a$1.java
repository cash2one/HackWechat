package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView.a;

class AdlandingSightPlayImageView$a$1 implements Runnable {
    final /* synthetic */ LayoutParams quL;
    final /* synthetic */ AdlandingSightPlayImageView rmr;
    final /* synthetic */ a rms;

    AdlandingSightPlayImageView$a$1(a aVar, AdlandingSightPlayImageView adlandingSightPlayImageView, LayoutParams layoutParams) {
        this.rms = aVar;
        this.rmr = adlandingSightPlayImageView;
        this.quL = layoutParams;
    }

    public final void run() {
        this.rmr.setLayoutParams(this.quL);
    }
}
