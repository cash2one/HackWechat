package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;

final class aa {
    final c iFw = new c(this);

    aa() {
    }

    static String ZZ() {
        String str = g.Dj().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/pkg/";
        i.Qu(str);
        return str;
    }

    final int b(ab abVar) {
        if (this.iFw.RU(abVar.vgd)) {
            x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", new Object[]{abVar.vgd});
            return 0;
        }
        x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", new Object[]{abVar.vgd, Integer.valueOf(this.iFw.b(abVar))});
        return this.iFw.b(abVar);
    }
}
