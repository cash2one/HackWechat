package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.c;

class b$c$1 implements Runnable {
    final /* synthetic */ c rmz;

    b$c$1(c cVar) {
        this.rmz = cVar;
    }

    public final void run() {
        if (this.rmz.riM == 1) {
            this.rmz.rmy.bxy();
            this.rmz.jNw.postDelayed(this.rmz.riQ, 100);
        }
    }
}
