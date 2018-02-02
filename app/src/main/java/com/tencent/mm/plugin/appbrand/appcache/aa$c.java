package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.pluginsdk.i.a.d.f.d;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.m;
import com.tencent.mm.pluginsdk.i.a.d.t;

final class aa$c extends m {
    final /* synthetic */ aa iFG;

    aa$c(aa aaVar) {
        this.iFG = aaVar;
        super(new t("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new aa$e(aaVar));
    }

    public final void shutdown() {
        super.shutdown();
        ((aa$e) this.vhQ).iFK.getLooper().quit();
    }

    protected final d a(k kVar) {
        d com_tencent_mm_plugin_appbrand_appcache_aa_d = new aa$d((ab) kVar);
        com_tencent_mm_plugin_appbrand_appcache_aa_d.vhT = this.vhQ;
        return com_tencent_mm_plugin_appbrand_appcache_aa_d;
    }

    protected final int b(k kVar) {
        int b = super.b(kVar);
        if (b != 1) {
            return b;
        }
        super.b(kVar);
        return 2;
    }
}
