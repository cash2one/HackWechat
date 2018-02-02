package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

class w$4 implements Runnable {
    final /* synthetic */ w rls;

    w$4(w wVar) {
        this.rls = wVar;
    }

    public final void run() {
        if (!w.k(this.rls)) {
            if (this.rls.rkM != null) {
                this.rls.rkM.iD(false);
            }
            this.rls.rkO.setVisibility(4);
            this.rls.rlb.setVisibility(8);
            w.j(this.rls).setVisibility(4);
        }
    }
}
