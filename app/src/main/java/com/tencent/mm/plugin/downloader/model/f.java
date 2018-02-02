package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.z.d;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class f {
    public static Map<Long, Long> lsh = new HashMap();
    private static int lso = 2;
    private static f lsq;
    p lsi;
    private p lsj;
    private p lsk;
    private p lsl;
    private p lsm;
    private p lsn;
    public c lsp;

    static /* synthetic */ PendingIntent cc(String str, String str2) {
        Intent intent = new Intent();
        Context context = ac.getContext();
        intent.setClass(context, FileDownloadService.class);
        intent.putExtra(FileDownloadService.lsG, 3);
        intent.putExtra(FileDownloadService.lsH, str);
        intent.putExtra(FileDownloadService.lsI, str2);
        return PendingIntent.getService(context, (int) System.currentTimeMillis(), intent, 0);
    }

    static /* synthetic */ void xK(String str) {
        x.i("MicroMsg.FileDownloadManager", "APK File Path: %s", str);
        if (!bh.ov(str)) {
            q.e(ac.getContext(), Uri.fromFile(new File(str)));
        }
    }

    public static f aAd() {
        if (lsq == null) {
            lsq = new f();
        }
        return lsq;
    }

    private f() {
        aAi();
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                lso = bh.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("FileDownloaderType"), 2);
                x.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(lso));
                this.lsp = new c();
            }
        }
        x.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.lsp = new c();
    }

    private p aAe() {
        x.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + lso);
        if (this.lsi != null) {
            return this.lsi;
        }
        b hgVar = new hg();
        com.tencent.mm.sdk.b.a.xef.m(hgVar);
        int i = hgVar.fxy.fwH;
        if (i > 0) {
            lso = i;
        }
        if (lso == 1) {
            this.lsi = aAf();
        } else {
            if (this.lsl == null) {
                this.lsl = new l(this.lsp);
            }
            this.lsi = this.lsl;
        }
        return this.lsi;
    }

    public final p aAf() {
        if (this.lsk == null) {
            this.lsk = new i(this.lsp);
        }
        return this.lsk;
    }

    public final p aAg() {
        if (this.lsj == null) {
            this.lsj = new k(this.lsp);
        }
        return this.lsj;
    }

    public final p aAh() {
        if (this.lsm == null) {
            this.lsm = new b(this.lsp);
        }
        return this.lsm;
    }

    public final long a(g gVar) {
        x.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(gVar.lsy), gVar.mAppId);
        if (gVar.lsy == 2) {
            if (this.lsn == null) {
                this.lsn = new m(this.lsp);
            }
            return this.lsn.a(gVar);
        }
        if (g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                return aAe().a(gVar);
            }
        }
        long a = aAf().a(gVar);
        if (a >= 0) {
            lsh.put(Long.valueOf(a), Long.valueOf(0));
            ac.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        aAg().a(gVar);
        return a;
    }

    public final int bX(long j) {
        x.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = " + j);
        if (cg(j)) {
            return aAf().bX(j);
        }
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || ce.field_downloaderType != 3) {
            return aAe().bX(j);
        }
        return aAh().bX(j);
    }

    public final FileDownloadTaskInfo bY(long j) {
        if (cg(j)) {
            return aAf().bY(j);
        }
        FileDownloadTaskInfo fileDownloadTaskInfo;
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce != null && ce.field_status == 3 && e.bO(ce.field_filePath)) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.url = ce.field_downloadUrl;
            fileDownloadTaskInfo.status = 3;
            fileDownloadTaskInfo.path = ce.field_filePath;
            fileDownloadTaskInfo.fqR = ce.field_md5;
            fileDownloadTaskInfo.fwf = ce.field_downloadedSize;
            fileDownloadTaskInfo.fwg = ce.field_totalSize;
            fileDownloadTaskInfo.lsK = ce.field_autoDownload;
            fileDownloadTaskInfo.fwH = ce.field_downloaderType;
        } else if (ce == null || ce.field_downloaderType != 3) {
            fileDownloadTaskInfo = aAe().bY(j);
            if (ce != null) {
                fileDownloadTaskInfo.lsK = ce.field_autoDownload;
                fileDownloadTaskInfo.fwH = ce.field_downloaderType;
            }
        } else {
            fileDownloadTaskInfo = aAh().bY(j);
        }
        if (fileDownloadTaskInfo == null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
        }
        x.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(fileDownloadTaskInfo.id), fileDownloadTaskInfo.url, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.path, fileDownloadTaskInfo.fqR, Long.valueOf(fileDownloadTaskInfo.fwg), Boolean.valueOf(fileDownloadTaskInfo.lsK), Integer.valueOf(fileDownloadTaskInfo.fwH));
        return fileDownloadTaskInfo;
    }

    public final FileDownloadTaskInfo xI(String str) {
        com.tencent.mm.plugin.downloader.e.a xE = e.xE(str);
        if (xE != null) {
            return bY(xE.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public final FileDownloadTaskInfo xJ(String str) {
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH != null) {
            return bY(xH.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public static ArrayList<FileDownloadTaskInfo> n(ArrayList<String> arrayList) {
        ArrayList arrayList2 = null;
        com.tencent.mm.plugin.downloader.e.b Fe = e.Fe();
        if (Fe != null) {
            Cursor rawQuery = Fe.rawQuery("select * from FileDownloadInfo where " + com.tencent.mm.plugin.downloader.e.b.o(arrayList), new String[0]);
            if (rawQuery != null) {
                arrayList2 = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.downloader.e.a aVar = new com.tencent.mm.plugin.downloader.e.a();
                        aVar.b(rawQuery);
                        arrayList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        ArrayList<FileDownloadTaskInfo> arrayList3 = new ArrayList();
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.e.a aVar2 = (com.tencent.mm.plugin.downloader.e.a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || e.bO(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.fqR = aVar2.field_md5;
                fileDownloadTaskInfo.fwf = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.fwg = aVar2.field_totalSize;
                fileDownloadTaskInfo.lsK = aVar2.field_autoDownload;
                fileDownloadTaskInfo.fwH = aVar2.field_downloaderType;
                arrayList3.add(fileDownloadTaskInfo);
            }
        }
        return arrayList3;
    }

    public final boolean bZ(long j) {
        x.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = " + j);
        if (cg(j)) {
            return aAf().bZ(j);
        }
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || ce.field_downloaderType != 3) {
            return aAe().bZ(j);
        }
        return aAh().bZ(j);
    }

    public final boolean ca(long j) {
        x.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = " + j);
        if (cg(j)) {
            return aAf().ca(j);
        }
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || ce.field_downloaderType != 3) {
            return aAe().ca(j);
        }
        return aAh().ca(j);
    }

    private static void aAi() {
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences != null) {
            Map all = sharedPreferences.getAll();
            if (all != null && all.size() != 0) {
                lsh.clear();
                for (Entry entry : all.entrySet()) {
                    if (!(entry == null || bh.ov((String) entry.getKey()))) {
                        try {
                            long j = bh.getLong((String) entry.getKey(), 0);
                            long longValue = ((Long) entry.getValue()).longValue();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                                lsh.put(Long.valueOf(j), Long.valueOf(longValue));
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                            x.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                        }
                    }
                }
                sharedPreferences.edit().clear();
                for (Entry entry2 : lsh.entrySet()) {
                    sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
                }
                sharedPreferences.edit().commit();
            }
        }
    }

    static void a(String str, String str2, PendingIntent pendingIntent) {
        d dVar = new d(ac.getContext());
        dVar.a(str);
        dVar.b(str2);
        dVar.U(17301634);
        dVar.n(true);
        if (pendingIntent != null) {
            dVar.sa = pendingIntent;
        } else {
            dVar.sa = PendingIntent.getActivity(ac.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build());
        x.i("MicroMsg.FileDownloadManager", "show notification");
    }

    static boolean cg(long j) {
        return lsh.containsKey(Long.valueOf(j));
    }

    static void q(long j, long j2) {
        lsh.put(Long.valueOf(j), Long.valueOf(j2));
        ac.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
    }

    static long ch(long j) {
        Long l = (Long) lsh.get(Long.valueOf(j));
        return l == null ? -1 : l.longValue();
    }

    final void i(long j, boolean z) {
        x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), bh.cgy());
        Context context = ac.getContext();
        if (cg(j)) {
            this.lsp.b(j, bY(j).path, z);
            return;
        }
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce != null) {
            if (bh.ov(ce.field_packageName)) {
                String RM = q.RM(ce.field_filePath);
                if (!bh.ov(RM)) {
                    ce.field_packageName = RM;
                    x.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", ce.field_filePath, RM);
                    e.c(ce);
                }
            }
            x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", ce.field_packageName, ce.field_filePath, Integer.valueOf(q.RN(ce.field_filePath)));
            g.Dm().F(new 1(this, ce, r4, context, j, z));
        }
    }
}
