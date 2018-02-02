package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aj.a;
import com.tencent.mm.plugin.appbrand.appcache.aj.a.b;
import com.tencent.mm.plugin.appbrand.appcache.g.3.1;
import com.tencent.mm.plugin.appbrand.appcache.g.4;
import com.tencent.mm.sdk.platformtools.ag;

class g$3$1$1 implements a {
    final /* synthetic */ 1 iDY;

    g$3$1$1(1 1) {
        this.iDY = 1;
    }

    public final void a(String str, b bVar, a.a aVar) {
        if (bVar == b.iGB) {
            ag.y(new 4(this.iDY.iDX.iDU, "公共库增量(maybe)更新成功，重启微信确认是否生效"));
        } else {
            ag.y(new 4(this.iDY.iDX.iDU, "公共库增量失败"));
        }
    }
}
