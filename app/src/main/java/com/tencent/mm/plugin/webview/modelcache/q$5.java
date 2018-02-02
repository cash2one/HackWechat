package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.a.b;
import com.tencent.mm.plugin.webview.modelcache.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class q$5 implements Runnable {
    final /* synthetic */ q ttX;
    final /* synthetic */ List tud;

    public q$5(q qVar, List list) {
        this.ttX = qVar;
        this.tud = list;
    }

    public final void run() {
        for (String str : this.tud) {
            x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", str);
            if (!bh.ov(str)) {
                int Al;
                if (str.startsWith("http://")) {
                    Al = a.Al(0);
                } else if (str.startsWith("https://")) {
                    Al = a.Am(a.Al(0));
                } else {
                    x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", str);
                }
                String OB = p.OB(str);
                k bRm = k.bRm();
                List m = !bRm.iYd ? null : bh.ov(OB) ? null : bRm.m(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), new String[]{String.valueOf(ab.UZ(OB).hashCode()), String.valueOf(Al)});
                if (bh.cA(r1)) {
                    x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", str, OB, a.toString(Al));
                } else {
                    String OB2 = p.OB(str);
                    if (!bh.ov(OB2)) {
                        Object obj;
                        long Wo = bh.Wo();
                        for (f fVar : r1) {
                            if (Wo - fVar.field_createTime > 60 && OB2.equals(fVar.field_version)) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", str);
                        } else {
                            byte[] OD = p.OD(str);
                            if (bh.bw(OD)) {
                                x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", str);
                            } else {
                                k bRm2 = k.bRm();
                                List m2 = !bRm2.iYd ? null : bh.ov(OB) ? null : bRm2.m(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", k.Ao(Al)}), new String[]{String.valueOf(ab.UZ(OB).hashCode())});
                                if (bh.cA(r0)) {
                                    x.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                } else {
                                    String bt = ab.bt(OD);
                                    for (f fVar2 : r0) {
                                        x.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", fVar2);
                                        if (!bh.ov(fVar2.field_localPath)) {
                                            if (bt.equals(fVar2.field_contentMd5)) {
                                                x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                            } else {
                                                a Ox = a.Ox(fVar2.field_appId);
                                                if (Ox != null) {
                                                    String str2 = fVar2.field_localPath;
                                                    if (!(bh.ov(str2) || bh.bw(OD))) {
                                                        if ((FileOp.j(str2, OD) == 0 ? 1 : null) != null && str2.startsWith(Ox.path)) {
                                                            b.a(Ox.ttr, Ox.appId, (long) OD.length);
                                                        }
                                                    }
                                                    fVar2.field_contentMd5 = bt;
                                                    k.bRm().b(fVar2);
                                                    x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", fVar2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
