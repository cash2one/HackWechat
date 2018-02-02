package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper.ResDownloaderPlugin;
import com.tencent.mm.pluginsdk.i.a.d.d;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;

class WebViewCacheDownloadHelper$ResDownloaderPlugin$1 implements d {
    final /* synthetic */ ResDownloaderPlugin tuj;

    WebViewCacheDownloadHelper$ResDownloaderPlugin$1(ResDownloaderPlugin resDownloaderPlugin) {
        this.tuj = resDownloaderPlugin;
    }

    public final void a(String str, l lVar) {
        b.c(str, lVar);
    }

    public final void b(String str, l lVar) {
        OG(str);
        b.c(str, lVar);
    }

    public final void OF(String str) {
        OG(str);
    }

    public final String aab() {
        return "WebViewCache";
    }

    private static void OG(String str) {
        q RW = a.bZC().RW(str);
        if (RW != null) {
            com.tencent.mm.pluginsdk.i.a.e.a.Sa(RW.field_filePath);
        }
    }
}
