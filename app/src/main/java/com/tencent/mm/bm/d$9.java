package com.tencent.mm.bm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements a {
    final /* synthetic */ int pa;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ String vzO;
    final /* synthetic */ String vzT;

    d$9(Intent intent, String str, String str2, Context context, int i) {
        this.val$intent = intent;
        this.vzO = str;
        this.vzT = str2;
        this.val$context = context;
        this.pa = i;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ac.getPackageName(), this.vzT.startsWith(".") ? (ac.cfr() + ".plugin." + this.vzO) + this.vzT : this.vzT);
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).startActivityForResult(intent, this.pa);
            d.b(this.val$context, this.vzT, intent);
            return;
        }
        x.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }
}
