package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.j;

class b$1 implements Runnable {
    final /* synthetic */ j iZy;
    final /* synthetic */ b jnZ;

    b$1(b bVar, j jVar) {
        this.jnZ = bVar;
        this.iZy = jVar;
    }

    public final void run() {
        this.iZy.irP.finish();
        Activity cg = com.tencent.mm.plugin.appbrand.ui.j.cg(this.iZy.getContext());
        if (cg != null && !cg.isFinishing()) {
            cg.moveTaskToBack(true);
        }
    }
}
