package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ad.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public enum j implements b {
    ;
    
    private int iEt;
    private String iEu;

    private j(String str) {
        this.iEt = -1;
        this.iEu = null;
    }

    final void A(int i, String str) {
        this.iEt = i;
        this.iEu = str;
    }

    public final void cn(boolean z) {
        Pair l = ad.l(z, true);
        if (l.second == null && l.first == a.iFY) {
            ae a = f.Zo().a("@LibraryAppId", z ? 0 : 999, new String[]{"downloadURL", "version"});
            if (a != null && !bh.ov(a.field_downloadURL)) {
                int i;
                if (z) {
                    i = a.field_version;
                } else {
                    i = 0;
                }
                aj.a 1 = new 1(this, i);
                if (z) {
                    if (this.iEt > 0 && !bh.ov(this.iEu)) {
                        x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", new Object[]{Boolean.valueOf(h.ZH())});
                        if (h.ZH()) {
                            if (ad.p("@LibraryAppId", 0, this.iEt).first == a.iFU) {
                                x.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                f.a("@LibraryAppId", this.iEt, a.field_version, this.iEu, 1);
                                return;
                            }
                            x.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", new Object[]{Integer.valueOf(this.iEt), this.iEu});
                        }
                    }
                    aj.a(a.field_downloadURL, a.field_version, 1);
                    return;
                }
                aj.a(a.field_downloadURL, 1);
            }
        }
    }
}
