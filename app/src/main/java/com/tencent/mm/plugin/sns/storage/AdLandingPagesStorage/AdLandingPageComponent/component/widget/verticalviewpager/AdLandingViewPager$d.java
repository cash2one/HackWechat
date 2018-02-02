package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.database.DataSetObserver;

class AdLandingViewPager$d extends DataSetObserver {
    final /* synthetic */ AdLandingViewPager rmF;

    private AdLandingViewPager$d(AdLandingViewPager adLandingViewPager) {
        this.rmF = adLandingViewPager;
    }

    public final void onChanged() {
        this.rmF.bR();
    }

    public final void onInvalidated() {
        this.rmF.bR();
    }
}
