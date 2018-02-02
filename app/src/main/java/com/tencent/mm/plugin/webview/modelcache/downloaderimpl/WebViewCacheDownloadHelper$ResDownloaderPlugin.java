package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.i.a.d.d;
import com.tencent.mm.pluginsdk.i.a.d.g;
import com.tencent.mm.pluginsdk.i.a.d.h;
import com.tencent.mm.pluginsdk.i.a.d.i;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.m;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class WebViewCacheDownloadHelper$ResDownloaderPlugin implements g {
    private final d tui = new 1(this);

    public final void bRs() {
        a.bZC().a("WebViewCache", this.tui);
    }

    public final void onAccountRelease() {
        c.clearCache();
        o bZC = a.bZC();
        String str = "WebViewCache";
        d dVar = this.tui;
        if (bZC.iYd) {
            i iVar = bZC.vhW;
            if (dVar != null) {
                int hashCode = str.hashCode();
                synchronized (iVar.vhF) {
                    List list = (List) iVar.vhE.get(hashCode);
                    if (list == null) {
                        return;
                    }
                    list.remove(dVar);
                }
            }
        }
    }

    public final String aab() {
        return "WebViewCache";
    }

    public final m.a c(k kVar) {
        if (kVar != null && (kVar instanceof e)) {
            return new c((e) kVar);
        }
        x.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + kVar);
        return null;
    }

    public final h bRt() {
        return new d();
    }
}
