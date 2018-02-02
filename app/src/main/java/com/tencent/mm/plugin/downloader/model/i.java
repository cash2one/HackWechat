package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class i extends j {
    ak ikI = new ak(new 2(this), false);
    private DownloadManager lsL = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> lsM = new CopyOnWriteArraySet();
    private Context mContext = ac.getContext();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(i iVar, Long l) {
        x.d("MicroMsg.FileDownloaderImpl23", "updateDownloadStatus");
        a ce = e.ce(l.longValue());
        if (ce != null) {
            Query query = new Query();
            query.setFilterById(new long[]{ce.field_sysDownloadId});
            try {
                Cursor query2 = iVar.lsL.query(query);
                if (query2 == null) {
                    x.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
                    iVar.lsM.remove(l);
                    ce.field_status = 4;
                    e.c(ce);
                    return;
                }
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex(DownloadInfo.STATUS);
                    int columnIndex2 = query2.getColumnIndex("local_uri");
                    int columnIndex3 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex4 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            x.d("MicroMsg.FileDownloaderImpl23", "status = %d", new Object[]{Integer.valueOf(query2.getInt(columnIndex))});
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    if (columnIndex3 != -1) {
                                        ce.field_downloadedSize = query2.getLong(columnIndex3);
                                    }
                                    if (columnIndex4 != -1) {
                                        ce.field_totalSize = query2.getLong(columnIndex4);
                                    }
                                    ce.field_status = 1;
                                    e.c(ce);
                                    iVar.lsp.cd(l.longValue());
                                    break;
                                case 4:
                                    iVar.lsM.remove(l);
                                    ce.field_status = 2;
                                    e.c(ce);
                                    iVar.lsp.cc(l.longValue());
                                    break;
                                case 8:
                                    iVar.lsM.remove(l);
                                    if (columnIndex2 != -1) {
                                        if (!bh.ov(ce.field_filePath) && e.bO(ce.field_filePath)) {
                                            Intent intent = new Intent();
                                            intent.setClass(ac.getContext(), FileDownloadService.class);
                                            intent.putExtra(FileDownloadService.EXTRA_ID, ce.field_downloadId);
                                            intent.putExtra(FileDownloadService.lsG, 1);
                                            ComponentName startService = ac.getContext().startService(intent);
                                            x.d("MicroMsg.FileDownloaderImpl23", "start download service: " + startService.getClassName() + ", " + startService.getPackageName());
                                            break;
                                        }
                                        x.e("MicroMsg.FileDownloaderImpl23", "path not exists, path = %s", new Object[]{ce.field_filePath});
                                        ce.field_status = 4;
                                        e.c(ce);
                                        return;
                                    }
                                    break;
                                case 16:
                                    iVar.lsM.remove(l);
                                    columnIndex = d.lsc;
                                    ce.field_status = 4;
                                    e.c(ce);
                                    iVar.lsp.b(l.longValue(), columnIndex, false);
                                    break;
                            }
                        } catch (Exception e) {
                            iVar.lsM.remove(l);
                            ce.field_status = 4;
                            e.c(ce);
                            x.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[]{e.toString()});
                        }
                    }
                }
                query2.close();
            } catch (Exception e2) {
                x.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[]{e2.toString(), l});
                iVar.lsM.remove(l);
                ce.field_status = 4;
                e.c(ce);
            }
        }
    }

    public i(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (gVar == null || bh.ov(gVar.iFI)) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            return -1;
        } else if (gVar.lsC) {
            x.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[]{gVar.mAppId});
            return -1;
        } else {
            String str = gVar.iFI;
            String str2 = "";
            a xH = e.xH(str);
            if (xH != null) {
                FileDownloadTaskInfo cj = cj(xH.field_sysDownloadId);
                if (cj.status == 1) {
                    return cj.id;
                }
                str2 = xH.field_filePath;
                this.lsL.remove(new long[]{xH.field_sysDownloadId});
            }
            String absolutePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!bh.ov(absolutePath)) {
                File file = new File(absolutePath);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    x.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[]{Boolean.valueOf(mkdir)});
                }
            }
            xQ(str2);
            e.xF(str);
            e.xG(gVar.mAppId);
            a b = h.b(gVar);
            b.field_downloadId = System.currentTimeMillis();
            b.field_status = 0;
            b.field_downloaderType = 1;
            b.field_filePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + ab.UZ(str);
            b.field_startTime = System.currentTimeMillis();
            e.b(b);
            g.Dm().F(new 1(this, gVar, b));
            return b.field_downloadId;
        }
    }

    public final int bX(long j) {
        int remove;
        Exception e;
        f.aAd();
        if (f.cg(j)) {
            f.aAd();
            long ch = f.ch(j);
            return this.lsL.remove(new long[]{ch});
        }
        a ce = e.ce(j);
        if (ce == null) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            return 0;
        }
        try {
            remove = this.lsL.remove(new long[]{ce.field_sysDownloadId});
            try {
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", new Object[]{Long.valueOf(j)});
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", new Object[]{Long.valueOf(j), e.toString()});
                b.deleteFile(ce.field_filePath);
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[]{ce.field_filePath});
                ce.field_status = 5;
                e.c(ce);
                this.lsp.cb(j);
                this.lsM.remove(Long.valueOf(j));
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
            x.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", new Object[]{Long.valueOf(j), e.toString()});
            b.deleteFile(ce.field_filePath);
            x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[]{ce.field_filePath});
            ce.field_status = 5;
            e.c(ce);
            this.lsp.cb(j);
            this.lsM.remove(Long.valueOf(j));
            return remove;
        }
        b.deleteFile(ce.field_filePath);
        x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", new Object[]{ce.field_filePath});
        ce.field_status = 5;
        e.c(ce);
        this.lsp.cb(j);
        this.lsM.remove(Long.valueOf(j));
        return remove;
    }

    public final FileDownloadTaskInfo bY(long j) {
        f.aAd();
        if (f.cg(j)) {
            f.aAd();
            FileDownloadTaskInfo cj = cj(f.ch(j));
            cj.id = j;
            cj.fwH = 1;
            return cj;
        }
        a ce = e.ce(j);
        if (ce == null) {
            return new FileDownloadTaskInfo();
        }
        if (ce.field_status == 4 || ce.field_status == 2 || ce.field_status == 5 || ce.field_status == 3) {
            this.lsM.remove(Long.valueOf(j));
        }
        cj = new FileDownloadTaskInfo();
        cj.id = ce.field_downloadId;
        cj.url = ce.field_downloadUrl;
        cj.status = ce.field_status;
        cj.path = ce.field_filePath;
        cj.fqR = ce.field_md5;
        cj.lsK = ce.field_autoDownload;
        cj.fwH = ce.field_downloaderType;
        cj.fwf = ce.field_downloadedSize;
        cj.fwg = ce.field_totalSize;
        return cj;
    }

    final long d(a aVar) {
        try {
            Request request = new Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!bh.ov(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(Uri.fromFile(new File(aVar.field_filePath)));
            long enqueue = this.lsL.enqueue(request);
            if (enqueue > 0) {
                return enqueue;
            }
            x.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            return -1;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[]{e.toString(), aVar.field_downloadUrl});
            return -1;
        }
    }

    private FileDownloadTaskInfo cj(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.lsL.query(query);
            if (query2 == null) {
                x.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex(DownloadInfo.STATUS);
                    int columnIndex2 = query2.getColumnIndex("uri");
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[]{e.toString()});
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (bh.ov(string)) {
                            x.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            x.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[]{string});
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            x.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[]{fileDownloadTaskInfo.path});
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.fwf = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.fwg = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                x.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[]{Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path});
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[]{e2.toString(), Long.valueOf(j)});
        }
        return fileDownloadTaskInfo;
    }

    public final boolean bZ(long j) {
        FileDownloadTaskInfo bY = bY(j);
        if (bY == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        }
        this.lsM.remove(Long.valueOf(j));
        if (bY.status != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[]{Long.valueOf(j)});
            return true;
        }
        x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[]{Long.valueOf(j), Integer.valueOf(bX(j))});
        if (bX(j) > 0) {
            return true;
        }
        return false;
    }

    public final boolean ca(long j) {
        a ce = e.ce(j);
        if (ce == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (ce.field_downloaderType != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[]{Long.valueOf(j)});
            b.deleteFile(ce.field_filePath);
            e.cf(j);
            return false;
        } else if (ce.field_status == 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[]{Long.valueOf(j)});
            return false;
        } else {
            this.lsL.remove(new long[]{ce.field_sysDownloadId});
            long d = d(ce);
            if (d > 0) {
                this.lsM.add(Long.valueOf(ce.field_downloadId));
                if (this.ikI.cfK()) {
                    this.ikI.J(100, 100);
                }
                ce.field_sysDownloadId = d;
                ce.field_status = 1;
                e.c(ce);
                return true;
            }
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            return false;
        }
    }
}
