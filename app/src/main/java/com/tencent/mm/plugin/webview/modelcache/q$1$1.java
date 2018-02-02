package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.plugin.webview.modelcache.e.c;
import com.tencent.mm.plugin.webview.modelcache.q.1;
import com.tencent.mm.plugin.webview.modelcache.q.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.i.a.c.d;
import com.tencent.mm.pluginsdk.i.a.c.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.SocketTimeoutException;
import java.util.List;

class q$1$1 implements Runnable {
    final /* synthetic */ f ttY;
    final /* synthetic */ 1 ttZ;

    q$1$1(1 1, f fVar) {
        this.ttZ = 1;
        this.ttY = fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        f fVar = this.ttY;
        if (fVar != null) {
            if (bh.ov(fVar.appId) || bh.ov(fVar.fMh) || bh.ov(fVar.filePath)) {
                x.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, invalid response = %s", new Object[]{fVar});
                return;
            }
            String str;
            Object obj;
            x.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response = %s", new Object[]{fVar});
            List<c> n = a.bRp().ttU.n(fVar.url, fVar.appId, fVar.fMh, fVar.fMi);
            Exception exception = fVar.exception;
            if (exception != null) {
                x.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, response.exception = %s", new Object[]{exception});
                if (!bh.cA(n)) {
                    str = exception instanceof SocketTimeoutException ? "timeout" : exception instanceof d ? "not support redirect resource" : exception instanceof g ? "not support 0kb resource" : (!(exception instanceof com.tencent.mm.pluginsdk.i.a.c.a) || fVar.fMk < 5242880) ? "batch download fail" : "exceed cache threshold";
                    for (c cVar : n) {
                        h.Be(cVar.ttA).z(cVar.ttB, fVar.fMj == 3 ? "publicCache" : "cache", str);
                        if (fVar.fMj == 1) {
                            a.bRp().ttU.a(cVar.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj, fVar.url);
                        } else {
                            a.bRp().ttU.b(cVar.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj);
                        }
                    }
                }
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m.fi(7);
                return;
            }
            if (e.bN(fVar.filePath) == 0) {
                x.i("MicroMsg.WebViewCacheDownloadResponseLogic", "onResponse, readFileLength = 0, return");
                if (!bh.cA(n)) {
                    for (c cVar2 : n) {
                        h.Be(cVar2.ttA).z(cVar2.ttB, fVar.fMj == 3 ? "publicCache" : "cache", "batch download fail");
                        a.bRp().ttU.a(cVar2.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj, fVar.url);
                    }
                }
                obj = null;
            } else {
                l lVar;
                String OB = p.OB(fVar.url);
                q bRp = a.bRp();
                String str2 = fVar.appId;
                String str3 = fVar.fMh;
                int i = fVar.fMj;
                String str4 = fVar.fMi;
                if (bh.ov(str2) || bh.ov(str3) || bh.ov(OB)) {
                    x.e("MicroMsg.WebViewCacheWorkerManager", "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s", new Object[]{str2, str3, OB});
                    lVar = null;
                } else {
                    int hashCode = String.format("%s_%s_%s_%s", new Object[]{str2, str3, Integer.valueOf(i), OB}).hashCode();
                    l lVar2 = (l) bRp.ttS.get(hashCode);
                    if (lVar2 == null) {
                        lVar2 = new l(str2, str3, i, OB, str4);
                        bRp.ttS.put(hashCode, lVar2);
                    }
                    lVar = lVar2;
                }
                obj = null;
                if (lVar != null) {
                    String str5 = fVar.filePath;
                    OB = fVar.version;
                    str4 = fVar.aBD;
                    if (bh.ov(str5)) {
                        x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, filePath is null or nil");
                        obj = -1;
                    } else if (!e.bO(str5)) {
                        x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file not exists");
                        obj = -1;
                    } else if (e.bN(str5) <= 0) {
                        x.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, file size = 0kb");
                        obj = 6;
                    } else if (bh.ov(OB)) {
                        x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, resVersion is null or nil, return");
                        obj = -1;
                    } else if (lVar.ttG == null) {
                        x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, appIdDir is null, return");
                        obj = -1;
                    } else {
                        long j;
                        f fVar2;
                        a aVar = lVar.ttG;
                        String str6 = lVar.fCa;
                        if (bh.ov(str5) || bh.ov(str6)) {
                            j = 0;
                        } else {
                            j = FileOp.x(str5, str6);
                            if (j > 0 && str6.startsWith(aVar.path)) {
                                b.a(aVar.ttr, aVar.appId, j);
                            }
                        }
                        k bRm = k.bRm();
                        str = lVar.appId;
                        String str7 = lVar.fMh;
                        int i2 = lVar.fMj;
                        String str8 = lVar.ttF;
                        String str9 = lVar.fMi;
                        if (bRm.iYd) {
                            if (bh.ov(str) || bh.ov(str7) || bh.ov(str8) || bh.ov(str9)) {
                                fVar2 = null;
                                if (fVar2 != null) {
                                    x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, no db record stored");
                                    obj = -1;
                                } else {
                                    fVar2.field_localPath = lVar.fCa;
                                    fVar2.field_version = OB;
                                    fVar2.field_contentType = str4;
                                    fVar2.field_contentMd5 = p.OE(fVar2.field_localPath);
                                    fVar2.field_contentLength = j;
                                    k.bRm().b(fVar2);
                                    x.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, updated record = %s", new Object[]{fVar2});
                                    obj = null;
                                }
                            } else {
                                fVar2 = new f();
                                fVar2.field_appId = str;
                                fVar2.field_domain = str7;
                                fVar2.field_cacheType = i2;
                                fVar2.field_urlMd5Hashcode = ab.UZ(str8).hashCode();
                                fVar2.field_packageId = str9;
                            }
                        }
                        fVar2 = null;
                        if (fVar2 != null) {
                            fVar2.field_localPath = lVar.fCa;
                            fVar2.field_version = OB;
                            fVar2.field_contentType = str4;
                            fVar2.field_contentMd5 = p.OE(fVar2.field_localPath);
                            fVar2.field_contentLength = j;
                            k.bRm().b(fVar2);
                            x.i("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, updated record = %s", new Object[]{fVar2});
                            obj = null;
                        } else {
                            x.e("MicroMsg.WebViewCacheResWriter", "writeRes with filePath, no db record stored");
                            obj = -1;
                        }
                    }
                    obj = obj == null ? 1 : null;
                }
                if (obj == null) {
                    if (!bh.cA(n)) {
                        for (c cVar22 : n) {
                            h.Be(cVar22.ttA).z(cVar22.ttB, fVar.fMj == 3 ? "publicCache" : "cache", "batch save fail");
                            if (fVar.fMj == 1) {
                                a.bRp().ttU.a(cVar22.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj, fVar.url);
                            } else {
                                a.bRp().ttU.b(cVar22.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj);
                            }
                        }
                    }
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj == null) {
                m.fi(8);
            } else if (fVar.fMj != 1) {
                k bRm2 = k.bRm();
                List m = !bRm2.iYd ? null : (bh.ov(fVar.appId) || bh.ov(fVar.fMh) || bh.ov(fVar.fMi)) ? null : bRm2.m(String.format("select * from %s where %s=? and %s=? and %s=?", new Object[]{"WebViewResourceCache", "appId", "domain", "packageId"}), new String[]{fVar.appId, fVar.fMh, fVar.fMi});
                if (!bh.cA(r0)) {
                    for (f fVar3 : r0) {
                        boolean z;
                        if (fVar3 == null) {
                            z = false;
                            continue;
                        } else {
                            z = !bh.ov(fVar3.field_contentMd5) && bh.ou(p.OE(fVar3.field_localPath)).equals(fVar3.field_contentMd5);
                            x.d("MicroMsg.WebViewCacheUtils", "isCacheResValid, cacheRes = %s, ret = %b", new Object[]{fVar3, Boolean.valueOf(z)});
                            continue;
                        }
                        if (!z) {
                            obj = null;
                            break;
                        }
                    }
                    int i3 = 1;
                    if (obj != null && !bh.cA(n)) {
                        for (c cVar222 : n) {
                            h.Be(cVar222.ttA).z(cVar222.ttB, "cache", "ok");
                            a.bRp().ttU.b(cVar222.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj);
                        }
                    }
                }
            } else if (!bh.cA(n)) {
                for (c cVar2222 : n) {
                    h.Be(cVar2222.ttA).z(cVar2222.ttB, "cache", "ok");
                    a.bRp().ttU.a(cVar2222.ttA, fVar.appId, fVar.fMh, fVar.fMi, fVar.fMj, fVar.url);
                }
            }
        }
    }
}
