package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.view.View;
import java.util.Comparator;

class AdLandingViewPager$e implements Comparator<View> {
    AdLandingViewPager$e() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AdLandingViewPager$LayoutParams adLandingViewPager$LayoutParams = (AdLandingViewPager$LayoutParams) ((View) obj).getLayoutParams();
        AdLandingViewPager$LayoutParams adLandingViewPager$LayoutParams2 = (AdLandingViewPager$LayoutParams) ((View) obj2).getLayoutParams();
        if (adLandingViewPager$LayoutParams.zB != adLandingViewPager$LayoutParams2.zB) {
            return adLandingViewPager$LayoutParams.zB ? 1 : -1;
        } else {
            return adLandingViewPager$LayoutParams.position - adLandingViewPager$LayoutParams2.position;
        }
    }
}
