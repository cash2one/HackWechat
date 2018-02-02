package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareParams;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.PrepareResult;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.1;
import com.tencent.mm.plugin.appbrand.launching.g.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$a$1$1 implements a {
    final /* synthetic */ 1 jxe;

    AppBrandPrepareTask$a$1$1(1 1) {
        this.jxe = 1;
    }

    public final void b(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar) {
        x.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", new Object[]{PrepareParams.a(this.jxe.jxc), aVar});
        PrepareResult prepareResult = new PrepareResult();
        PrepareResult.a(prepareResult, 5);
        PrepareResult.a(prepareResult, aVar);
        this.jxe.jxb.as(prepareResult);
    }
}
