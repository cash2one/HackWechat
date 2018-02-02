package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.page.u.4;
import com.tencent.mm.sdk.platformtools.bc;

class p$4 implements v {
    final /* synthetic */ p jEg;

    p$4(p pVar) {
        this.jEg = pVar;
    }

    public final boolean ajc() {
        if (this.jEg.irP.YF()) {
            return false;
        }
        u uVar = this.jEg.jDQ;
        bc 4 = new 4(uVar, Boolean.valueOf(false));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            4.b(null);
        }
        4.b(uVar.mHandler);
        return true;
    }
}
