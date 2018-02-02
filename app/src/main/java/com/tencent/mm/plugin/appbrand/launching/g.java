package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

final class g {
    final int iOd;
    final WxaAttributes jxJ;
    final a jxK;

    public interface a {
        void b(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar);
    }

    g(String str, int i, a aVar) {
        this.iOd = i;
        this.jxJ = f.Zh().e(str, new String[0]);
        this.jxK = aVar;
    }
}
