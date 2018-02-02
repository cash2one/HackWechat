package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

class AdLandingViewPager$3 implements Runnable {
    final /* synthetic */ AdLandingViewPager rmF;

    AdLandingViewPager$3(AdLandingViewPager adLandingViewPager) {
        this.rmF = adLandingViewPager;
    }

    public final void run() {
        AdLandingViewPager.a(this.rmF);
        this.rmF.populate();
    }
}
