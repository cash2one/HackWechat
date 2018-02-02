package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

public final class WebViewCacheDownloadHelper {
    private static final byte[] tug = new byte[0];
    private static volatile WebViewCacheDownloadHelper tuh = null;

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper bRq() {
        if (tuh == null) {
            synchronized (tug) {
                if (tuh == null) {
                    tuh = new WebViewCacheDownloadHelper();
                }
            }
        }
        return tuh;
    }

    public static void bRr() {
        FileOp.G(a.tuf, false);
    }

    static void a(f fVar) {
        b tpVar = new tp();
        tpVar.fMg.url = fVar.url;
        tpVar.fMg.filePath = fVar.filePath;
        tpVar.fMg.version = fVar.version;
        tpVar.fMg.appId = fVar.appId;
        tpVar.fMg.fMh = fVar.fMh;
        tpVar.fMg.fMi = fVar.fMi;
        tpVar.fMg.fMj = fVar.fMj;
        tpVar.fMg.aBD = fVar.aBD;
        tpVar.fMg.exception = fVar.exception;
        tpVar.fMg.fMk = fVar.fMk;
        a.xef.a(tpVar, Looper.getMainLooper());
    }
}
