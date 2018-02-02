package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.appbrand.m.b.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class o implements b {
    public final WxaAttributes qK(String str) {
        return f.Zh().e(str, new String[0]);
    }

    public final void a(String str, a aVar) {
        r.a(str, new 1(this, aVar));
    }

    public final void qL(String str) {
        if (!bh.ov(str)) {
            ag agVar = new ag();
            new af(agVar.oAt.getLooper()).post(new 2(this, str, null, agVar));
        }
    }

    public final void Z(List<String> list) {
        if (!bh.cA(list)) {
            x.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[]{bh.d(list, ", ")});
            r.a(list, k.a.iOO);
        }
    }
}
