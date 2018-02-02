package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.p.a;

class m$3 extends a {
    final /* synthetic */ m jDi;
    final /* synthetic */ Context val$context;

    m$3(m mVar, Context context) {
        this.jDi = mVar;
        this.val$context = context;
    }

    public final void onActivityPaused(Activity activity) {
        if (activity == this.val$context) {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            if (this.jDi.jDg != null && this.jDi.jDg.isShowing()) {
                this.jDi.jDg.bxh();
            }
        }
    }
}
