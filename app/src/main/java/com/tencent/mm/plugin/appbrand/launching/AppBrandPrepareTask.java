package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask {
    PrepareParams jwV = new PrepareParams();
    public volatile transient b jwW;
    volatile transient WeakReference<MMActivity> jwX;
    boolean jwY;

    public AppBrandPrepareTask(MMActivity mMActivity, e eVar) {
        int i = 0;
        AppBrandStatObject appBrandStatObject = eVar.iqH;
        this.jwX = new WeakReference(mMActivity);
        PrepareParams.a(this.jwV, eVar.mAppId);
        PrepareParams.a(this.jwV, eVar.iqw.iGA);
        PrepareParams.b(this.jwV, appBrandStatObject == null ? 0 : appBrandStatObject.fIs);
        PrepareParams prepareParams = this.jwV;
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        PrepareParams.c(prepareParams, i);
        PrepareParams.b(this.jwV, eVar.iqw.iNW);
        PrepareParams.a(this.jwV, eVar.iqw.iNZ);
        PrepareParams.c(this.jwV, eVar.iqw.irG);
        PrepareParams.a(this.jwV, eVar.Yz());
        this.jwY = eVar.Yz();
    }

    public final void ahN() {
        if (ag.isMainThread()) {
            com.tencent.mm.sdk.f.e.post(new 1(this), "AppBrandPrepareTask" + this.jwV.toShortString());
            return;
        }
        if (!v.ZN()) {
            x.i("MicroMsg.AppBrandPrepareTask", "startPrepare(), CommLib not loaded, %s", this.jwV.toShortString());
            v.ks();
        }
        PrepareParams.d(this.jwV, v.ZP().iGL);
        XIPCInvoker.a("com.tencent.mm", this.jwV, a.class, new 2(this));
        x.i("MicroMsg.AppBrandPrepareTask", "[applaunch] startPrepare in appbrand %s, %d", PrepareParams.a(this.jwV), Integer.valueOf(PrepareParams.b(this.jwV)));
    }
}
