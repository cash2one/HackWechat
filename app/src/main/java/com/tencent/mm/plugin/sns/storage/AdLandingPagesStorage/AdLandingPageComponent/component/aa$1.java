package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

class aa$1 implements Runnable {
    final /* synthetic */ aa rlI;

    aa$1(aa aaVar) {
        this.rlI = aaVar;
    }

    public final void run() {
        try {
            aa.a(this.rlI).await();
        } catch (InterruptedException e) {
        }
        this.rlI.contentView.post(new Runnable(this) {
            final /* synthetic */ aa$1 rlJ;

            {
                this.rlJ = r1;
            }

            public final void run() {
                aa.a(this.rlJ.rlI, aa.b(this.rlJ.rlI), aa.c(this.rlJ.rlI));
            }
        });
    }
}
