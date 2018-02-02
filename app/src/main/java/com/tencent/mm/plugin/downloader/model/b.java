package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.z.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends j {
    private static final String lrF = (a.bnF + "BigFile");
    private byte[] gSF;
    private HashMap<String, Long> lrG;
    private HashMap<String, Long> lrH;
    private ConcurrentHashMap<String, Integer> lrI;
    private com.tencent.mm.plugin.downloader.d.b lrl;
    private Context mContext;

    static /* synthetic */ void a(b bVar, String str, int i, int i2, boolean z) {
        x.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH == null) {
            x.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
        } else if (xH.field_showNotification) {
            d dVar = new d(bVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                bVar.lrG.put(str, Long.valueOf(currentTimeMillis));
                dVar.c(currentTimeMillis);
            } else {
                Long l = (Long) bVar.lrG.get(str);
                if (l != null) {
                    dVar.c(l.longValue());
                }
            }
            dVar.a(xH.field_fileName);
            switch (i) {
                case 1:
                    dVar.U(17301633);
                    dVar.a(100, i2, i2 == 0);
                    dVar.b(bVar.mContext.getString(c.ehe));
                    dVar.c(2, true);
                    long j = xH.field_downloadId;
                    Intent intent = new Intent(bVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.sa = PendingIntent.getActivity(bVar.mContext, (int) System.currentTimeMillis(), intent, SQLiteDatabase.CREATE_IF_NECESSARY);
                    break;
                case 4:
                    dVar.U(17301634);
                    dVar.n(true);
                    dVar.sa = PendingIntent.getActivity(ac.getContext(), 0, new Intent(), 0);
                    dVar.b(bVar.mContext.getString(c.ehd));
                    break;
                default:
                    bVar.cancelNotification(str);
                    return;
            }
            synchronized (bVar.gSF) {
                Integer num = (Integer) bVar.lrI.get(str);
                if (num == null) {
                    bVar.lrI.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build())));
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), dVar.build());
                }
                if (i == 4) {
                    bVar.lrI.remove(str);
                }
            }
        }
    }

    public b(c cVar) {
        super(cVar);
        this.gSF = new byte[0];
        this.lrl = new 1(this);
        this.mContext = ac.getContext();
        this.lrG = new HashMap();
        this.lrH = new HashMap();
        this.lrI = new ConcurrentHashMap();
        com.tencent.mm.plugin.downloader.d.a.azU().lrl = this.lrl;
    }

    public final long a(g gVar) {
        if (gVar == null || bh.ov(gVar.iFI)) {
            x.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            return -1;
        }
        String str = gVar.iFI;
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (xH != null) {
            fileDownloadTaskInfo = bY(xH.field_downloadId);
            x.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
            if (fileDownloadTaskInfo.status == 1) {
                return fileDownloadTaskInfo.id;
            }
        }
        File file = new File(lrF);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", parentFile.getAbsolutePath());
                }
            }
            x.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(file.mkdirs()));
        }
        e.xF(str);
        e.xG(gVar.mAppId);
        xH = h.b(gVar);
        xH.field_downloadId = System.currentTimeMillis();
        xH.field_downloaderType = 3;
        xH.field_filePath = lrF + "/" + ab.UZ(str);
        if (fileDownloadTaskInfo == null || !xH.field_filePath.equals(fileDownloadTaskInfo.path)) {
            xH.field_startState = 0;
        } else {
            String str2 = xH.field_filePath;
            String str3 = fileDownloadTaskInfo.path;
            if (!(str2 == null || str3 == null || str2.equals(str3))) {
                if (new File(str3).exists()) {
                    x.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(new File(str3).delete()));
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                xH.field_startState = 2;
            } else if (fileDownloadTaskInfo.status == 4) {
                xH.field_startState = 4;
            } else {
                xH.field_startState = 0;
            }
            xH.field_startSize = fileDownloadTaskInfo.fwf;
            x.d("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.fwf);
        }
        xH.field_startTime = System.currentTimeMillis();
        new Thread(new 2(this, xH, str)).start();
        return xH.field_downloadId;
    }

    private static CDNTaskInfo a(com.tencent.mm.plugin.downloader.e.a aVar) {
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.htz = true;
        cDNTaskInfo.mediaId = aVar.field_downloadUrl;
        cDNTaskInfo.downloadUrl = aVar.field_downloadUrl;
        cDNTaskInfo.filePath = aVar.field_filePath;
        cDNTaskInfo.lry = aVar.field_secondaryUrl;
        cDNTaskInfo.lrA = 15;
        cDNTaskInfo.lrB = 3600;
        cDNTaskInfo.lrC = true;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.field_fileSize > 0) {
                jSONObject.put("Content-Length", aVar.field_fileSize);
            }
            cDNTaskInfo.lrz = jSONObject.toString();
        } catch (JSONException e) {
            x.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e.getMessage());
        }
        return cDNTaskInfo;
    }

    public final int bX(final long j) {
        new Thread(new Runnable(this) {
            final /* synthetic */ b lrJ;

            public final void run() {
                com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
                if (ce != null) {
                    com.tencent.mm.plugin.downloader.d.a.azU().xB(ce.field_downloadUrl);
                    this.lrJ.cancelNotification(ce.field_downloadUrl);
                    if (ce.field_status != 5) {
                        e.j(ce.field_downloadId, 5);
                        this.lrJ.lsp.cb(j);
                    }
                }
            }
        }).start();
        return 1;
    }

    public final FileDownloadTaskInfo bY(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce != null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            CDNTaskState xC = com.tencent.mm.plugin.downloader.d.a.azU().xC(ce.field_downloadUrl);
            if (xC != null) {
                switch (xC.taskState) {
                    case 100:
                    case 101:
                        fileDownloadTaskInfo.status = 1;
                        break;
                    case 102:
                        fileDownloadTaskInfo.status = 2;
                        break;
                    default:
                        fileDownloadTaskInfo.status = 0;
                        break;
                }
                fileDownloadTaskInfo.fwf = (long) xC.completeSize;
                fileDownloadTaskInfo.fwg = (long) xC.fileTotalSize;
            } else {
                if (ce.field_status == 1) {
                    fileDownloadTaskInfo.status = 0;
                } else {
                    fileDownloadTaskInfo.status = ce.field_status;
                }
                fileDownloadTaskInfo.fwf = ce.field_downloadedSize;
                fileDownloadTaskInfo.fwg = ce.field_totalSize;
            }
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.fwH = ce.field_downloaderType;
            fileDownloadTaskInfo.lsK = ce.field_autoDownload;
            fileDownloadTaskInfo.path = ce.field_filePath;
            fileDownloadTaskInfo.url = ce.field_downloadUrl;
            fileDownloadTaskInfo.fqR = ce.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final boolean bZ(long j) {
        new Thread(new 4(this, j)).start();
        return true;
    }

    public final boolean ca(long j) {
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || ce.field_status != 2) {
            return false;
        }
        new Thread(new 5(this, ce, j)).start();
        return true;
    }

    private void cancelNotification(String str) {
        synchronized (this.gSF) {
            Integer num = (Integer) this.lrI.get(str);
            if (num == null) {
                x.i("MicroMsg.FileCDNDownloader", "No notification id found");
                return;
            }
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
            x.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + num);
            this.lrI.remove(str);
        }
    }
}
