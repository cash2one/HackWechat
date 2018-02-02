package com.tencent.mm.pluginsdk.i.a.b;

import android.os.Looper;
import android.support.v4.e.a;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.i.a.c.c;
import com.tencent.mm.pluginsdk.i.a.d.d;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.protocal.c.bcy;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aq;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class b {
    private final d tui;
    private final Set<b> vgp;
    private final k vgq;

    final Set<b> bZk() {
        Set<b> newSetFromMap;
        synchronized (this.vgp) {
            newSetFromMap = Collections.newSetFromMap(new a(this.vgp.size()));
            for (b add : this.vgp) {
                newSetFromMap.add(add);
            }
        }
        return newSetFromMap;
    }

    public final void e(int i, int i2, int i3, boolean z) {
        a.vhX.A(new 1(this, i, i2, i3, z));
    }

    private b() {
        this.vgp = Collections.newSetFromMap(new a(i.vgS.length));
        this.vgq = new k();
        this.tui = new d(this) {
            final /* synthetic */ b vgv;

            {
                this.vgv = r1;
            }

            public final void a(String str, l lVar) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + str);
                q RW = a.vhX.RW(str);
                if (RW != null) {
                    j.I(RW.field_reportId, 10);
                    j.I(RW.field_reportId, 15);
                    if ((!RW.field_fileCompress || RW.field_fileEncrypt) && RW.field_fileUpdated) {
                        j.a(RW.field_resType, RW.field_subType, RW.field_url, bh.getInt(RW.field_fileVersion, 0), RW.field_maxRetryTimes > RW.field_retryTimes ? j$a.vhg : j$a.vhe, true, bh.ou(RW.field_groupId2).equals("NewXml"), false, RW.field_sampleId);
                    }
                    if (RW.field_fileCompress || RW.field_fileEncrypt) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                        this.vgv.a(RW);
                        return;
                    }
                    com.tencent.mm.sdk.b.b bcVar = new bc();
                    bcVar.fpl.filePath = RW.field_filePath;
                    bcVar.fpl.fpp = RW.field_fileUpdated;
                    bcVar.fpl.fpo = bh.getInt(RW.field_fileVersion, 0);
                    bcVar.fpl.fpm = RW.field_resType;
                    bcVar.fpl.fpn = RW.field_subType;
                    com.tencent.mm.sdk.b.a.xef.a(bcVar, Looper.getMainLooper());
                    RW.field_fileUpdated = false;
                    a.vhX.e(RW);
                }
            }

            public final void b(String str, l lVar) {
                i.RS(str);
                q RW = a.vhX.RW(str);
                if (RW != null) {
                    boolean z = true;
                    if (!(lVar == null || lVar.vhO == null)) {
                        if (lVar.vhO instanceof com.tencent.mm.pluginsdk.i.a.c.a) {
                            j.I(RW.field_reportId, 7);
                            z = false;
                        } else if (lVar.vhO instanceof c) {
                            j.I(RW.field_reportId, 16);
                            z = false;
                        }
                    }
                    if (z) {
                        j.I(RW.field_reportId, 11);
                    }
                    j.I(RW.field_reportId, 44);
                    j.a(RW.field_resType, RW.field_subType, RW.field_url, bh.getInt(RW.field_fileVersion, 0), j$a.vhf, false, "NewXml".equalsIgnoreCase(RW.field_groupId2), false, RW.field_sampleId);
                }
            }

            public final void OF(String str) {
                o bZC = a.vhX;
                if (!(bZC.iYd ? bZC.vhV.isDownloading(str) : false)) {
                    i.RS(str);
                }
            }

            public final String aab() {
                return "CheckResUpdate";
            }
        };
        a.vhX.a("CheckResUpdate", this.tui);
    }

    public static void BH(int i) {
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[]{Integer.valueOf(i)});
        g.Dh();
        boolean Cx = com.tencent.mm.kernel.a.Cx();
        boolean equals = aq.hfP.H("login_user_name", "").equals("");
        if (Cx || !equals) {
            g.Di().gPJ.a(new m(i), 0);
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
    }

    public static String ex(int i, int i2) {
        q RW = a.vhX.RW(i.ey(i, i2));
        if (RW == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return null;
        }
        x.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", new Object[]{Boolean.valueOf(RW.field_deleted), RW.field_filePath, RW.field_md5, Boolean.valueOf(RW.field_fileCompress), Boolean.valueOf(RW.field_fileEncrypt), RW.field_originalMd5});
        if (RW.field_fileCompress || RW.field_fileEncrypt) {
            String str;
            if (RW.field_fileCompress) {
                str = RW.field_filePath + ".decompressed";
            } else if (RW.field_fileEncrypt) {
                str = RW.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (bh.ov(str)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return null;
            } else if (bh.ov(RW.field_originalMd5) || !bh.ou(com.tencent.mm.a.g.bV(str)).equals(RW.field_originalMd5)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return null;
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                return str;
            }
        } else if (RW.field_deleted || bh.ov(RW.field_filePath) || !bh.ou(com.tencent.mm.a.g.bV(RW.field_filePath)).equals(RW.field_md5)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return null;
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), RW.field_filePath});
            return RW.field_filePath;
        }
    }

    final void a(q qVar) {
        x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + qVar.field_urlKey);
        k kVar = this.vgq;
        if (kVar.RU(qVar.field_urlKey)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            return;
        }
        kVar.a(new a(qVar.field_urlKey, qVar.field_resType, qVar.field_subType, bh.getInt(qVar.field_fileVersion, 0), qVar.field_fileUpdated, qVar.field_filePath, qVar.field_fileEncrypt, qVar.field_fileCompress, qVar.field_encryptKey, qVar.field_keyVersion, qVar.field_eccSignature, qVar.field_originalMd5, bh.ou(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_sampleId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_retryTimes));
    }

    final void a(int i, bcy com_tencent_mm_protocal_c_bcy, boolean z) {
        String ey = i.ey(i, com_tencent_mm_protocal_c_bcy.wFj);
        if (com_tencent_mm_protocal_c_bcy.wJb == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wFj), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJb.wJl)});
        j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 3);
        int i2 = com_tencent_mm_protocal_c_bcy.wJb.wJl;
        a.vhX.A(new 4(this, ey, i, com_tencent_mm_protocal_c_bcy.wFj, i2, com_tencent_mm_protocal_c_bcy.wJd, com_tencent_mm_protocal_c_bcy.wJe, z));
    }

    final void b(int i, bcy com_tencent_mm_protocal_c_bcy, boolean z) {
        String ey = i.ey(i, com_tencent_mm_protocal_c_bcy.wFj);
        if (com_tencent_mm_protocal_c_bcy.wJb == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(), resource.Info = null, return");
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_bcy.wFj);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJb.wJl);
        if (com_tencent_mm_protocal_c_bcy.wJb.wJn == null) {
            str = "null";
        } else {
            str = String.valueOf(com_tencent_mm_protocal_c_bcy.wJb.wJn.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJd);
        objArr[6] = com_tencent_mm_protocal_c_bcy.wJe;
        objArr[7] = com_tencent_mm_protocal_c_bcy.wJb.nfX;
        objArr[8] = com_tencent_mm_protocal_c_bcy.wJb.vZC;
        x.i(str2, str3, objArr);
        if (com_tencent_mm_protocal_c_bcy.wJb.wJn != null) {
            Iterator it = com_tencent_mm_protocal_c_bcy.wJb.wJn.iterator();
            while (it.hasNext()) {
                bip com_tencent_mm_protocal_c_bip = (bip) it.next();
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bip.ktM), com_tencent_mm_protocal_c_bip.wMc.cdp()});
            }
        }
        j.fu((long) com_tencent_mm_protocal_c_bcy.wJd);
        if (!z) {
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 1);
        }
        if (com_tencent_mm_protocal_c_bcy.vQa != 0 && ((long) com_tencent_mm_protocal_c_bcy.vQa) <= bh.Wo()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", new Object[]{ey, Integer.valueOf(com_tencent_mm_protocal_c_bcy.vQa), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJb.wJl)});
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 14);
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 44);
            j.a(i, com_tencent_mm_protocal_c_bcy.wFj, com_tencent_mm_protocal_c_bcy.wJb.nfX, com_tencent_mm_protocal_c_bcy.wJb.wJl, j$a.vhi, false, z, false, com_tencent_mm_protocal_c_bcy.wJe);
        } else if (bh.ov(com_tencent_mm_protocal_c_bcy.wJb.nfX) && com_tencent_mm_protocal_c_bcy.wJb.vZC == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
        } else {
            com.tencent.mm.pluginsdk.i.a.d.a.a aVar = new g.a(com_tencent_mm_protocal_c_bcy.wJb.nfX);
            aVar.vgd = ey;
            aVar.fpm = i;
            aVar.fpn = com_tencent_mm_protocal_c_bcy.wFj;
            aVar.hQs = (long) com_tencent_mm_protocal_c_bcy.vQa;
            aVar.fpo = com_tencent_mm_protocal_c_bcy.wJb.wJl;
            aVar.fqR = com_tencent_mm_protocal_c_bcy.wJb.vZU;
            aVar.vgM = i$a.BJ(com_tencent_mm_protocal_c_bcy.wJb.wJm);
            aVar.vgN = i$a.BI(com_tencent_mm_protocal_c_bcy.wJb.wJm);
            aVar.vgl = (long) com_tencent_mm_protocal_c_bcy.wJd;
            aVar.vgm = com_tencent_mm_protocal_c_bcy.wJe;
            aVar.vgn = com_tencent_mm_protocal_c_bcy.wJf > 0 ? com_tencent_mm_protocal_c_bcy.wJf : 3;
            aVar.vgO = com_tencent_mm_protocal_c_bcy.vgO;
            aVar.networkType = com_tencent_mm_protocal_c_bcy.wJg;
            aVar.fpt = z;
            if (!bh.cA(com_tencent_mm_protocal_c_bcy.wJb.wJn)) {
                aVar.vgi = ((bip) com_tencent_mm_protocal_c_bcy.wJb.wJn.get(0)).wMc.oz;
            }
            if (!(com_tencent_mm_protocal_c_bcy.wJc == null || bh.ov(com_tencent_mm_protocal_c_bcy.wJc.wJk))) {
                aVar.vgg = com_tencent_mm_protocal_c_bcy.wJc.wJk;
                aVar.vgh = com_tencent_mm_protocal_c_bcy.wJc.wJj;
            }
            if (com_tencent_mm_protocal_c_bcy.wJb.vZC != null && com_tencent_mm_protocal_c_bcy.wJb.vZC.oz.length > 0) {
                aVar.vgL = com_tencent_mm_protocal_c_bcy.wJb.vZC.toByteArray();
            }
            aVar.vgj = com_tencent_mm_protocal_c_bcy.wJb.wJo;
            aVar.fileSize = (long) com_tencent_mm_protocal_c_bcy.wJb.vYh;
            aVar.priority = com_tencent_mm_protocal_c_bcy.wrD;
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", new Object[]{new g(aVar.url, aVar.vgd, aVar.fpo, aVar.networkType, aVar.vgn, aVar.hQs, aVar.fqR, aVar.fpm, aVar.fpn, aVar.vgl, aVar.vgm, aVar.vgi, aVar.vgj, aVar.vgM, aVar.vgN, aVar.vgg, aVar.vgh, aVar.vgO, aVar.vgL, aVar.fileSize, aVar.fpt, aVar.fpp, aVar.priority).toString()});
            a.vhX.A(new 5(this, ey, r2));
        }
    }

    final void c(int i, bcy com_tencent_mm_protocal_c_bcy, boolean z) {
        final String ey = i.ey(i, com_tencent_mm_protocal_c_bcy.wFj);
        if (com_tencent_mm_protocal_c_bcy.wJc == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
        } else if (bh.ov(com_tencent_mm_protocal_c_bcy.wJc.wJk)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wFj), Integer.valueOf(com_tencent_mm_protocal_c_bcy.wJc.wJj)});
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", new Object[]{com_tencent_mm_protocal_c_bcy.wJc.wJk});
            j.I((long) com_tencent_mm_protocal_c_bcy.wJd, 4);
            final String str = com_tencent_mm_protocal_c_bcy.wJb.wJo;
            final String str2 = com_tencent_mm_protocal_c_bcy.wJc.wJk;
            final int i2 = com_tencent_mm_protocal_c_bcy.wJc.wJj;
            final int i3 = com_tencent_mm_protocal_c_bcy.wJd;
            final String str3 = com_tencent_mm_protocal_c_bcy.wJe;
            a.vhX.A(new Runnable(this) {
                final /* synthetic */ b vgv;

                public final void run() {
                    q RW = a.vhX.RW(ey);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    if (RW == null) {
                        RW = new q();
                        RW.field_keyVersion = i;
                        RW.field_encryptKey = str2;
                        RW.field_reportId = (long) i2;
                        RW.field_sampleId = str3;
                        RW.field_originalMd5 = str;
                        a.vhX.e(RW);
                        j.I((long) i2, 51);
                        j.I((long) i2, 45);
                    } else if (RW.field_keyVersion < i) {
                        RW.field_keyVersion = i;
                        RW.field_encryptKey = str2;
                        RW.field_reportId = (long) i2;
                        RW.field_sampleId = str3;
                        if (bh.ov(RW.field_originalMd5)) {
                            RW.field_originalMd5 = str;
                        }
                        a.vhX.e(RW);
                        com.tencent.mm.pluginsdk.i.a.b.f.b.a(RW, true);
                    }
                }
            });
        }
    }

    final void b(int i, int i2, String str, int i3) {
        a.vhX.A(new 7(this, i, i2, str, i3));
    }

    final void f(int i, int i2, int i3, boolean z) {
        if (a.vhX.handler == null) {
            x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
        } else {
            a.vhX.handler.post(new 2(this, i3, i, i2, z));
        }
    }
}
