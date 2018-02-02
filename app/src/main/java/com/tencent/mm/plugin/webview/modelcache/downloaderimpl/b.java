package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.o.a;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.x;

final class b {
    static void c(String str, l lVar) {
        q RW = a.bZC().RW(str);
        if (RW == null) {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", str);
        } else if ("WebViewCache".equals(RW.field_groupId1)) {
            RW.field_contentType = lVar.aBD;
            a.bZC().e(RW);
            f fVar = new f(RW.field_url, RW.field_filePath, RW.field_fileVersion, RW.field_appId, RW.field_groupId2, RW.field_packageId, RW.field_wvCacheType, lVar.aBD, lVar.fMk, lVar.vhO);
            WebViewCacheDownloadHelper.bRq();
            WebViewCacheDownloadHelper.a(fVar);
        } else {
            x.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", str, RW.field_groupId1);
        }
    }
}
