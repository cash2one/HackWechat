package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.e;

class AdlandingVideoSightView$1 implements e {
    final /* synthetic */ AdlandingVideoSightView rmv;

    AdlandingVideoSightView$1(AdlandingVideoSightView adlandingVideoSightView) {
        this.rmv = adlandingVideoSightView;
    }

    public final void xb(int i) {
        if (-1 == i) {
            if (this.rmv.quG != null) {
                this.rmv.quG.onError(0, 0);
            }
        } else if (i == 0 && this.rmv.quG != null) {
            this.rmv.quG.vh();
        }
    }
}
