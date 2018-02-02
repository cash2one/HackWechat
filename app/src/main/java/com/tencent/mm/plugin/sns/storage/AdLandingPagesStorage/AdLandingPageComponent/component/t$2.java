package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

class t$2 implements Runnable {
    final /* synthetic */ t rkG;

    t$2(t tVar) {
        this.rkG = tVar;
    }

    public final void run() {
        int measuredWidth = this.rkG.fvf.getMeasuredWidth();
        if (measuredWidth > this.rkG.kDP) {
            this.rkG.rky = (measuredWidth - this.rkG.kDP) / 2;
            this.rkG.rkB.scrollBy(this.rkG.rky, 0);
        }
    }
}
