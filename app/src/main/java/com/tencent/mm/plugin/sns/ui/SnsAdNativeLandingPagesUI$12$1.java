package com.tencent.mm.plugin.sns.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.12;

class SnsAdNativeLandingPagesUI$12$1 implements OnPreDrawListener {
    final /* synthetic */ RecyclerView ryA;
    final /* synthetic */ 12 ryB;

    SnsAdNativeLandingPagesUI$12$1(12 12, RecyclerView recyclerView) {
        this.ryB = 12;
        this.ryA = recyclerView;
    }

    public final boolean onPreDraw() {
        this.ryA.getViewTreeObserver().removeOnPreDrawListener(this);
        this.ryB.ryv.ryj = this.ryB.ryv.ryj - 1;
        SnsAdNativeLandingPagesUI.d(this.ryB.ryv);
        return true;
    }
}
