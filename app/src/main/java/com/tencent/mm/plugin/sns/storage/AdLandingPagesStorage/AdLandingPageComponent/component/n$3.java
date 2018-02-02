package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.g;

class n$3 implements Runnable {
    final /* synthetic */ n rjH;
    final /* synthetic */ Intent val$intent;

    n$3(n nVar, Intent intent) {
        this.rjH = nVar;
        this.val$intent = intent;
    }

    public final void run() {
        g.a(this.rjH.context, this.val$intent, g.l(this.rjH.context, n.b(this.rjH).fFm), new 1(this));
    }
}
