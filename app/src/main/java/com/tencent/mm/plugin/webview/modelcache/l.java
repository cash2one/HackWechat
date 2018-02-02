package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.x;

public final class l {
    final String appId;
    final String fCa;
    final String fMh;
    final String fMi;
    final int fMj;
    final String ttF;
    final a ttG;

    public l(String str, String str2, int i, String str3, String str4) {
        this.appId = str;
        this.fMh = str2;
        this.ttF = str3;
        this.fMj = i;
        this.fMi = str4;
        x.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", new Object[]{str, str2, str3, Integer.valueOf(i)});
        this.ttG = a.Ox(str);
        if (this.ttG != null) {
            a aVar = this.ttG;
            this.fCa = aVar.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            return;
        }
        this.fCa = null;
        x.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
    }
}
