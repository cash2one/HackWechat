package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

public final class m extends j {
    private static final String lrF = (a.bnF + "WebNetFile");
    private HashMap<String, Long> lrH = new HashMap();
    private i.a lsQ = new i.a(this) {
        final /* synthetic */ m lsR;

        {
            this.lsR = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2;
            String str3 = "MicroMsg.FileWebNetDownloader";
            String str4 = "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo == null ? "null" : com_tencent_mm_modelcdntran_keep_ProgressInfo.toString();
            if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                str2 = "null";
            } else {
                str2 = com_tencent_mm_modelcdntran_keep_SceneResult.toString();
            }
            objArr[3] = str2;
            x.d(str3, str4, objArr);
            if (i == -21006) {
                x.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", new Object[]{str});
            } else if (i != 0) {
                x.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                m.a(this.lsR, str, 4, i);
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                m.a(this.lsR, str, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength);
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    x.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                    m.a(this.lsR, str, 4, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                } else {
                    x.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", new Object[]{str});
                    m.a(this.lsR, str, 3, 0);
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    private Context mContext = ac.getContext();

    static /* synthetic */ void a(m mVar, String str, int i, int i2) {
        x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode= %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null});
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH == null) {
            x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, info is null");
            return;
        }
        x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), null});
        switch (i) {
            case 3:
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.lsG, 1);
                intent.setClass(mVar.mContext, FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, xH.field_downloadId);
                try {
                    mVar.mContext.startService(intent);
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.FileWebNetDownloader", e.getMessage());
                    return;
                }
            case 4:
                xH.field_errCode = Math.abs(i2);
                xH.field_status = 4;
                e.c(xH);
                mVar.lsp.b(xH.field_downloadId, Math.abs(i2), false);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(m mVar, String str, long j, long j2) {
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH == null) {
            x.i("MicroMsg.FileWebNetDownloader", "updateProgressChange, info is null");
            return;
        }
        Long l = (Long) mVar.lrH.get(xH.field_downloadUrl);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l == null || valueOf.longValue() - l.longValue() >= 500) {
            mVar.lrH.put(xH.field_downloadUrl, valueOf);
            xH.field_status = 1;
            xH.field_downloadedSize = j;
            xH.field_totalSize = j2;
            e.c(xH);
            mVar.lsp.cd(xH.field_downloadId);
        }
    }

    public m(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (gVar == null || bh.ov(gVar.iFI)) {
            x.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            return -1;
        }
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[]{gVar.iFI});
        String str = gVar.iFI;
        com.tencent.mm.plugin.downloader.e.a xH = e.xH(str);
        if (xH != null) {
            FileDownloadTaskInfo bY = bY(xH.field_downloadId);
            x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + bY.status);
            if (bY.status == 1) {
                return bY.id;
            }
        }
        e.xF(str);
        e.xG(gVar.mAppId);
        com.tencent.mm.plugin.downloader.e.a b = h.b(gVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_downloaderType = 4;
        b.field_filePath = lrF + "/" + ab.UZ(str);
        if (xH != null) {
            str = b.field_filePath;
            String str2 = xH.field_filePath;
            if (!(str == null || str2 == null || str.equals(str2))) {
                if (new File(str2).exists()) {
                    x.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[]{Boolean.valueOf(new File(str2).delete())});
                }
            }
        }
        b.field_startTime = System.currentTimeMillis();
        File file = new File(lrF);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[]{parentFile.getAbsolutePath()});
                }
            }
            x.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[]{Boolean.valueOf(file.mkdirs())});
        }
        i iVar = new i();
        iVar.htu = gVar.iFI;
        iVar.field_mediaId = gVar.iFI;
        if (gVar.lsy == 2) {
            iVar.field_fileType = b.hrX;
            iVar.htv = 20;
            iVar.htw = 90;
        }
        iVar.field_fullpath = b.field_filePath;
        iVar.htt = this.lsQ;
        boolean b2 = g.MJ().b(iVar, -1);
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: " + b2);
        if (b2) {
            b.field_status = 1;
            e.b(b);
            this.lsp.i(b.field_downloadId, b.field_filePath);
        } else {
            b.field_status = 4;
            b.field_errCode = d.lrT;
            e.b(b);
            this.lsp.b(b.field_downloadId, b.field_errCode, false);
        }
        return b.field_downloadId;
    }

    public final FileDownloadTaskInfo bY(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(ce.field_downloadUrl);
            if (ce.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == 101))) {
                fileDownloadTaskInfo.status = ce.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.fwf = ce.field_downloadedSize;
            fileDownloadTaskInfo.fwg = ce.field_totalSize;
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.fwH = ce.field_downloaderType;
            fileDownloadTaskInfo.lsK = ce.field_autoDownload;
            fileDownloadTaskInfo.path = ce.field_filePath;
            fileDownloadTaskInfo.url = ce.field_downloadUrl;
            fileDownloadTaskInfo.fqR = ce.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final int bX(long j) {
        new Thread(new 1(this, j)).start();
        return 1;
    }

    public final boolean bZ(final long j) {
        new Thread(new Runnable(this) {
            final /* synthetic */ m lsR;

            public final void run() {
                x.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
                FileDownloadTaskInfo bY = this.lsR.bY(j);
                if (bY != null && bY.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(bY.url);
                    e.j(bY.id, 2);
                    this.lsR.lsp.cc(j);
                }
            }
        }).start();
        return true;
    }

    public final boolean ca(long j) {
        com.tencent.mm.plugin.downloader.e.a ce = e.ce(j);
        if (ce == null || ce.field_status != 2) {
            return false;
        }
        new Thread(new 3(this, ce, j)).start();
        return true;
    }
}
