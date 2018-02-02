package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.support.v4.view.ViewPager.e;

class AdlandingDummyViewPager$a implements e {
    final /* synthetic */ AdlandingDummyViewPager rmI;

    private AdlandingDummyViewPager$a(AdlandingDummyViewPager adlandingDummyViewPager) {
        this.rmI = adlandingDummyViewPager;
    }

    public final void a(int i, float f, int i2) {
        for (e a : AdlandingDummyViewPager.a(this.rmI)) {
            a.a(i, f, i2);
        }
    }

    public final void ae(int i) {
        for (e ae : AdlandingDummyViewPager.a(this.rmI)) {
            ae.ae(i);
        }
    }

    public final void af(int i) {
        if (i == 0) {
            this.rmI.rmJ = this.rmI.getScrollX();
        }
        for (e af : AdlandingDummyViewPager.a(this.rmI)) {
            af.af(i);
        }
    }
}
