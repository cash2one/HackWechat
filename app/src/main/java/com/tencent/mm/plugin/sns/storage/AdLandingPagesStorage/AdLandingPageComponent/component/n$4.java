package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.pluginsdk.model.app.g;

class n$4 implements Runnable {
    final /* synthetic */ n rjH;

    n$4(n nVar) {
        this.rjH = nVar;
    }

    public final void run() {
        g.a(this.rjH.context, this.rjH.context.getPackageManager().getLaunchIntentForPackage(n.b(this.rjH).uC), g.l(this.rjH.context, n.b(this.rjH).fFm), new 1(this));
    }
}
