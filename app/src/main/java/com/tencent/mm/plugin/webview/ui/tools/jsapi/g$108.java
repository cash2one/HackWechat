package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.modelcache.f;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

class g$108 implements Runnable {
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJw;

    g$108(g gVar, String str) {
        this.tIj = gVar;
        this.tJw = str;
    }

    public final void run() {
        List list = null;
        a.bRp();
        String str = this.tJw;
        if (!bh.ov(str)) {
            k bRm = k.bRm();
            if (bRm.iYd && !bh.ov(str)) {
                list = bRm.m(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), new String[]{str});
            }
            if (!bh.cA(r0)) {
                for (f fVar : r0) {
                    com.tencent.mm.plugin.webview.modelcache.a Ox = com.tencent.mm.plugin.webview.modelcache.a.Ox(fVar.field_appId);
                    if (Ox != null) {
                        String str2 = fVar.field_localPath;
                        if (!bh.ov(str2)) {
                            long me = str2.startsWith(Ox.path) ? FileOp.me(str2) : 0;
                            if (FileOp.deleteFile(str2) && str2.startsWith(Ox.path)) {
                                b bVar = Ox.ttr;
                                String str3 = Ox.appId;
                                if (bVar.iYd) {
                                    c aVar = new a();
                                    aVar.field_appId = str3;
                                    if (bVar.b(aVar, new String[0])) {
                                        aVar.field_occupation = Math.max(0, aVar.field_occupation - me);
                                        bVar.c(aVar, new String[0]);
                                    }
                                }
                            }
                        }
                    }
                }
                k bRm2 = k.bRm();
                if (bRm2.iYd && !bh.ov(str)) {
                    c fVar2 = new f();
                    fVar2.field_domain = str;
                    bRm2.a(fVar2, new String[]{"domain"});
                }
            }
        }
        WebViewCacheDownloadHelper.bRr();
    }
}
