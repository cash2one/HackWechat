package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ g lsN;
    final /* synthetic */ i lsO;

    i$1(i iVar, g gVar, a aVar) {
        this.lsO = iVar;
        this.lsN = gVar;
        this.lrK = aVar;
    }

    public final void run() {
        if (this.lsN.lsB) {
            this.lrK.field_md5 = h.xP(this.lrK.field_downloadUrl);
        }
        long d = this.lsO.d(this.lrK);
        if (d > 0) {
            this.lrK.field_sysDownloadId = d;
            this.lrK.field_status = 1;
            e.c(this.lrK);
            this.lsO.lsp.i(this.lrK.field_downloadId, this.lrK.field_filePath);
            f.aAd();
            if (f.cg(this.lrK.field_downloadId)) {
                f.aAd();
                f.q(this.lrK.field_downloadId, d);
            }
            this.lsO.lsM.add(Long.valueOf(this.lrK.field_downloadId));
            if (this.lsO.ikI.cfK()) {
                this.lsO.ikI.J(100, 100);
            }
            x.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(this.lrK.field_downloadId), this.lrK.field_downloadUrl, this.lrK.field_filePath);
            return;
        }
        this.lrK.field_status = 4;
        e.c(this.lrK);
        this.lsO.lsp.b(this.lrK.field_downloadId, d.lsc, false);
        x.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
    }
}
