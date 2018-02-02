package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.d.a;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ b lrJ;
    final /* synthetic */ long lrL;

    b$4(b bVar, long j) {
        this.lrJ = bVar;
        this.lrL = j;
    }

    public final void run() {
        x.d("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
        FileDownloadTaskInfo bY = this.lrJ.bY(this.lrL);
        if (bY != null && bY.status == 1) {
            a.azU().xA(bY.url);
            e.j(bY.id, 2);
            this.lrJ.lsp.cc(this.lrL);
            b.a(this.lrJ, bY.url);
        }
    }
}
