package com.tencent.mm.plugin.downloader.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ long lrL;
    final /* synthetic */ m lsR;

    m$3(m mVar, a aVar, long j) {
        this.lsR = mVar;
        this.lrK = aVar;
        this.lrL = j;
    }

    public final void run() {
        int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(this.lrK.field_downloadUrl);
        x.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: " + resumeHttpMultiSocketDownloadTask);
        this.lrK.field_startTime = System.currentTimeMillis();
        this.lrK.field_startState = d.lse;
        this.lrK.field_startSize = this.lrK.field_downloadedSize;
        if (resumeHttpMultiSocketDownloadTask == 0) {
            this.lrK.field_status = 1;
            this.lrK.field_errCode = 0;
            e.c(this.lrK);
            this.lsR.lsp.j(this.lrL, this.lrK.field_filePath);
            if (this.lrK.field_totalSize != 0) {
                long j = this.lrK.field_downloadedSize;
                j = this.lrK.field_totalSize;
                return;
            }
            return;
        }
        this.lrK.field_status = 4;
        this.lrK.field_errCode = d.lrU;
        e.c(this.lrK);
        this.lsR.lsp.b(this.lrL, this.lrK.field_errCode, false);
    }
}
