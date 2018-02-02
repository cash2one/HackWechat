package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;

class b$5 implements Runnable {
    final /* synthetic */ b lrJ;
    final /* synthetic */ a lrK;
    final /* synthetic */ long lrL;

    b$5(b bVar, a aVar, long j) {
        this.lrJ = bVar;
        this.lrK = aVar;
        this.lrL = j;
    }

    public final void run() {
        long j = 0;
        int b = com.tencent.mm.plugin.downloader.d.a.azU().b(b.a(this.lrJ, this.lrK));
        x.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: " + b);
        this.lrK.field_startTime = System.currentTimeMillis();
        this.lrK.field_startState = d.lse;
        this.lrK.field_startSize = this.lrK.field_downloadedSize;
        if (b == 0) {
            this.lrK.field_status = 1;
            this.lrK.field_errCode = 0;
            e.c(this.lrK);
            this.lrJ.lsp.j(this.lrL, this.lrK.field_filePath);
            if (this.lrK.field_totalSize != 0) {
                j = this.lrK.field_downloadedSize / this.lrK.field_totalSize;
            }
            b.a(this.lrJ, this.lrK.field_downloadUrl, 1, (int) j, true);
        } else if (b == -2) {
            this.lrK.field_status = 1;
            this.lrK.field_errCode = 0;
            e.c(this.lrK);
        } else {
            this.lrK.field_status = 4;
            this.lrK.field_errCode = d.lrU;
            e.c(this.lrK);
            this.lrJ.lsp.b(this.lrL, this.lrK.field_errCode, false);
        }
    }
}
