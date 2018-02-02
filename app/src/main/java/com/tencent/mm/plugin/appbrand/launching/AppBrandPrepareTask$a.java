package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.sdk.platformtools.x;

final class AppBrandPrepareTask$a implements h<AppBrandPrepareTask$PrepareParams, AppBrandPrepareTask$PrepareResult> {
    private AppBrandPrepareTask$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        AppBrandPrepareTask$PrepareParams appBrandPrepareTask$PrepareParams = (AppBrandPrepareTask$PrepareParams) obj;
        String a = appBrandPrepareTask$PrepareParams.mAppId;
        int b = appBrandPrepareTask$PrepareParams.jxk;
        int c = appBrandPrepareTask$PrepareParams.jxi;
        String d = appBrandPrepareTask$PrepareParams.jxj;
        d$b 1 = new 1(this, iVar, appBrandPrepareTask$PrepareParams);
        d sY = d.sY(appBrandPrepareTask$PrepareParams.jxm);
        if (sY == null) {
            sY = new d(a, b, appBrandPrepareTask$PrepareParams.jxh, c, d, appBrandPrepareTask$PrepareParams.jxl, appBrandPrepareTask$PrepareParams.jxm, appBrandPrepareTask$PrepareParams.jxn, false, appBrandPrepareTask$PrepareParams.jwY);
            g 2 = new 2(this, iVar, sY);
            if (com.tencent.mm.kernel.g.Dk().gQE.gQX) {
                2.ul();
            } else {
                x.i("MicroMsg.AppBrandPrepareTask", "prepareCall kernel startup not done yet, wait for it");
                com.tencent.mm.kernel.g.Dk().a(2);
            }
        }
        sY.jxx = 1;
        if (sY.started && sY.jxy != null) {
            x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] setCallback already done %s %d", new Object[]{sY.appId, Integer.valueOf(sY.iKd)});
            sY.a(sY.jxy);
        }
    }
}
