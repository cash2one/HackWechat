package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a;
import com.tencent.mm.plugin.appbrand.launching.d.b;
import com.tencent.mm.plugin.appbrand.launching.g.1;

class AppBrandPrepareTask$a$1 implements b {
    final /* synthetic */ i jxb;
    final /* synthetic */ PrepareParams jxc;
    final /* synthetic */ a jxd;

    AppBrandPrepareTask$a$1(a aVar, i iVar, PrepareParams prepareParams) {
        this.jxd = aVar;
        this.jxb = iVar;
        this.jxc = prepareParams;
    }

    public final void ahO() {
        if (this.jxb != null) {
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.a(prepareResult, 1);
            this.jxb.as(prepareResult);
        }
    }

    public final void kO(int i) {
        if (this.jxb != null) {
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.b(prepareResult, i);
            PrepareResult.a(prepareResult, 4);
            this.jxb.as(prepareResult);
        }
    }

    public final void a(AppBrandSysConfig appBrandSysConfig, AppBrandLaunchErrorAction appBrandLaunchErrorAction) {
        if (this.jxb != null) {
            if (appBrandSysConfig != null) {
                g.Dh();
                appBrandSysConfig.uin = com.tencent.mm.kernel.a.Cg();
            }
            if (appBrandSysConfig != null) {
                appBrandSysConfig.iOL = com.tencent.mm.plugin.appbrand.game.cgipkg.a.rG(appBrandSysConfig.appId);
            }
            PrepareResult prepareResult = new PrepareResult();
            PrepareResult.a(prepareResult, 2);
            PrepareResult.a(prepareResult, appBrandSysConfig);
            PrepareResult.a(prepareResult, appBrandLaunchErrorAction);
            this.jxb.as(prepareResult);
            if (appBrandSysConfig != null) {
                g gVar = new g(appBrandSysConfig.fnl, PrepareParams.c(this.jxc), new 1(this));
                r.a(gVar.jxJ.field_username, new 1(gVar));
            }
        }
    }
}
