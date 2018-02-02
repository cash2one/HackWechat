package com.tencent.mm.plugin.sns.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class SnsSightPlayerUI$3 implements OnPreDrawListener {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$3(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final boolean onPreDraw() {
        this.rGv.qvc.getViewTreeObserver().removeOnPreDrawListener(this);
        this.rGv.kSb.a(this.rGv.qvc, SnsSightPlayerUI.s(this.rGv), null);
        return true;
    }
}
