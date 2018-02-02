package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<e> {
    private static final ConcurrentHashMap<String, Boolean> tuk = new ConcurrentHashMap();

    public c(e eVar) {
        super(eVar);
    }

    public final boolean aac() {
        return true;
    }

    public final boolean aad() {
        return false;
    }

    public final boolean aae() {
        return true;
    }

    public final boolean aag() {
        return false;
    }

    public final String aab() {
        return "WebViewCache";
    }

    public final boolean bD(long j) {
        if (super.bD(j) && j < 5242880) {
            return true;
        }
        return false;
    }

    protected final l a(j jVar) {
        if (tuk.putIfAbsent(((e) aai()).getFilePath(), Boolean.TRUE) != null) {
            x.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", ((e) aai()).vgd);
            return null;
        }
        l a = super.a(jVar);
        tuk.remove(((e) aai()).getFilePath());
        return a;
    }

    public static void clearCache() {
        tuk.clear();
    }
}
