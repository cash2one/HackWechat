package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.x;

class a$7 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ long lrL;
    final /* synthetic */ a sdR;

    a$7(a aVar, a aVar2, long j) {
        this.sdR = aVar;
        this.lrK = aVar2;
        this.lrL = j;
    }

    public final void run() {
        try {
            if (a.a(this.sdR).getDownloadTaskState(this.lrK.field_downloadUrl).mState != 3) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, not paused");
                return;
            }
            if (a.a(this.sdR).startDownloadTask(this.lrK.field_downloadUrl, this.lrK.field_secondaryUrl, this.lrK.field_fileSize, 0, "resource/tm.android.unknown", this.lrK.field_fileName, this.lrK.field_autoDownload, this.sdR.sdM) == 0) {
                this.lrK.field_status = 1;
                e.c(this.lrK);
                this.sdR.sdL.add(Long.valueOf(this.lrK.field_downloadId));
                a.a(this.sdR, this.lrK.field_downloadUrl, 2, 0, true);
                a aVar = this.sdR;
                a.a(6, this.lrK.field_downloadId, this.lrK.field_filePath);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[]{Long.valueOf(this.lrL)});
                return;
            }
            this.lrK.field_status = 4;
            this.lrK.field_errCode = d.lrS;
            e.c(this.lrK);
            a.a(this.sdR, this.lrK.field_downloadId, d.lrS, false);
        } catch (Throwable e) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
        }
    }
}
