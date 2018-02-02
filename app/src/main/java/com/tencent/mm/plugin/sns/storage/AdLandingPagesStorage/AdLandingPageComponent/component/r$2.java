package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.model.app.g;

class r$2 implements Runnable {
    final /* synthetic */ String iGk;
    final /* synthetic */ r rkv;
    final /* synthetic */ Context rkw;
    final /* synthetic */ Intent val$intent;

    r$2(r rVar, Context context, Intent intent, String str) {
        this.rkv = rVar;
        this.rkw = context;
        this.val$intent = intent;
        this.iGk = str;
    }

    public final void run() {
        g.a(this.rkw, this.val$intent, this.iGk);
    }
}
