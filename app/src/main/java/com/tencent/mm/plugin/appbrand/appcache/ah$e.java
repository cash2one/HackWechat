package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ah.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.m;
import java.io.InputStream;

final class ah$e implements b<m> {
    private ah$e() {
    }

    public final /* synthetic */ Object c(String str, InputStream inputStream) {
        return new m(s.SW(str), "UTF-8", inputStream);
    }
}
