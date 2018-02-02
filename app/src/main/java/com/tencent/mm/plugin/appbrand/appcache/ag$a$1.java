package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ag.a;
import com.tencent.mm.plugin.appbrand.config.m.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.sdk.platformtools.x;

class ag$a$1 implements c {
    final /* synthetic */ String fgU;
    final /* synthetic */ int iGh;
    final /* synthetic */ a iGi;

    ag$a$1(a aVar, String str, int i) {
        this.iGi = aVar;
        this.fgU = str;
        this.iGh = i;
    }

    public final void pL(String str) {
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", new Object[]{str});
        d.j(this.fgU, this.iGh, str);
    }
}
