package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

class AdLandingViewPager$c extends a {
    final /* synthetic */ AdLandingViewPager rmF;

    AdLandingViewPager$c(AdLandingViewPager adLandingViewPager) {
        this.rmF = adLandingViewPager;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
        f cj = f.cj();
        cj.setScrollable(bZ());
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && AdLandingViewPager.b(this.rmF) != null) {
            cj.setItemCount(AdLandingViewPager.b(this.rmF).getCount());
            cj.setFromIndex(AdLandingViewPager.c(this.rmF));
            cj.setToIndex(AdLandingViewPager.c(this.rmF));
        }
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(AdLandingViewPager.class.getName());
        bVar.setScrollable(bZ());
        if (this.rmF.canScrollHorizontally(1)) {
            bVar.addAction(Downloads.RECV_BUFFER_SIZE);
        }
        if (this.rmF.canScrollHorizontally(-1)) {
            bVar.addAction(8192);
        }
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                if (!this.rmF.canScrollHorizontally(1)) {
                    return false;
                }
                this.rmF.ah(AdLandingViewPager.c(this.rmF) + 1);
                return true;
            case 8192:
                if (!this.rmF.canScrollHorizontally(-1)) {
                    return false;
                }
                this.rmF.ah(AdLandingViewPager.c(this.rmF) - 1);
                return true;
            default:
                return false;
        }
    }

    private boolean bZ() {
        return AdLandingViewPager.b(this.rmF) != null && AdLandingViewPager.b(this.rmF).getCount() > 1;
    }
}
