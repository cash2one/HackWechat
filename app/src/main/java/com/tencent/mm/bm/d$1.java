package com.tencent.mm.bm;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMWizardActivity;

class d$1 implements a {
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ String vzO;
    final /* synthetic */ String vzT;

    d$1(Intent intent, String str, String str2, Context context) {
        this.val$intent = intent;
        this.vzO = str;
        this.vzT = str2;
        this.val$context = context;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ac.getPackageName(), this.vzT.startsWith(".") ? (ac.cfr() + ".plugin." + this.vzO) + this.vzT : this.vzT);
        MMWizardActivity.A(this.val$context, intent);
    }
}
