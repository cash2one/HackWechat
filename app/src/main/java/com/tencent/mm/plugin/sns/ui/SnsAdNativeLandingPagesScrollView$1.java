package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesScrollView$1 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesScrollView rxA;

    SnsAdNativeLandingPagesScrollView$1(SnsAdNativeLandingPagesScrollView snsAdNativeLandingPagesScrollView) {
        this.rxA = snsAdNativeLandingPagesScrollView;
    }

    public final void run() {
        int scrollY = this.rxA.getScrollY();
        x.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[]{Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.rxA)), Integer.valueOf(scrollY)});
        if (scrollY != SnsAdNativeLandingPagesScrollView.a(this.rxA)) {
            if (SnsAdNativeLandingPagesScrollView.b(this.rxA) != null) {
                SnsAdNativeLandingPagesScrollView.b(this.rxA);
                SnsAdNativeLandingPagesScrollView.c(this.rxA);
            }
            SnsAdNativeLandingPagesScrollView.a(this.rxA, System.currentTimeMillis());
        }
        if (SnsAdNativeLandingPagesScrollView.a(this.rxA) - scrollY == 0) {
            if (SnsAdNativeLandingPagesScrollView.b(this.rxA) != null) {
                SnsAdNativeLandingPagesScrollView.b(this.rxA);
                SnsAdNativeLandingPagesScrollView.a(this.rxA);
                SnsAdNativeLandingPagesScrollView.c(this.rxA);
            }
            SnsAdNativeLandingPagesScrollView.a(this.rxA, SnsAdNativeLandingPagesScrollView.a(this.rxA));
        }
        SnsAdNativeLandingPagesScrollView.b(this.rxA, this.rxA.getScrollY());
        x.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[]{Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(this.rxA)), Integer.valueOf(scrollY)});
        this.rxA.postDelayed(SnsAdNativeLandingPagesScrollView.d(this.rxA), (long) SnsAdNativeLandingPagesScrollView.e(this.rxA));
    }
}
