package com.tencent.mm.plugin.appbrand;

import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;

class e$11 extends b {
    final /* synthetic */ e irf;
    final /* synthetic */ AppBrandSysConfig iri;
    final /* synthetic */ int irj;

    e$11(e eVar, AppBrandSysConfig appBrandSysConfig, int i) {
        this.irf = eVar;
        this.iri = appBrandSysConfig;
        this.irj = i;
    }

    public final void j(Bitmap bitmap) {
        this.irf.iqt.setTaskDescription(new TaskDescription(this.iri.frn, bitmap, this.irj));
    }
}
