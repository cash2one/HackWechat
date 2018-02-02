package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.c;
import com.tencent.mm.sdk.platformtools.x;

class c$c$1 implements Runnable {
    final /* synthetic */ c riR;

    c$c$1(c cVar) {
        this.riR = cVar;
    }

    public final void run() {
        if (this.riR.riM == 1) {
            c cVar = this.riR;
            x.d("AdLandingCarouselComp", "onDraggin first visible " + cVar.riI.riF.eZ() + ", last visible " + cVar.riI.riF.fa());
            c.a(cVar.riI);
            this.riR.jNw.postDelayed(this.riR.riQ, 100);
        }
    }
}
