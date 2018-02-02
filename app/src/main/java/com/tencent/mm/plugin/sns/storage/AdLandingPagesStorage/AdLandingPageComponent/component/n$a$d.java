package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n.a;
import com.tencent.mm.sdk.d.b;

class n$a$d extends b {
    final /* synthetic */ a rjT;

    n$a$d(a aVar) {
        this.rjT = aVar;
    }

    public final void enter() {
        super.enter();
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b b = n.b(this.rjT.rjH);
        Object obj = (b.rfI == 0 || b.rfI == 2) ? 1 : null;
        if (obj != null) {
            this.rjT.b(this.rjT.rjL);
        } else {
            this.rjT.b(this.rjT.rjR);
        }
    }
}
