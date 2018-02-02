package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b lrJ;
    final /* synthetic */ a lrK;
    final /* synthetic */ String val$url;

    b$2(b bVar, a aVar, String str) {
        this.lrJ = bVar;
        this.lrK = aVar;
        this.val$url = str;
    }

    public final void run() {
        int a = com.tencent.mm.plugin.downloader.d.a.azU().a(b.a(this.lrJ, this.lrK));
        x.i("MicroMsg.FileCDNDownloader", "addDownloadTask: " + a);
        if (a == 0) {
            this.lrK.field_status = 1;
            e.b(this.lrK);
            this.lrJ.lsp.i(this.lrK.field_downloadId, this.lrK.field_filePath);
            b.a(this.lrJ, this.val$url, 1, 0, true);
        } else if (a == -2) {
            this.lrK.field_status = 1;
            e.b(this.lrK);
        } else {
            this.lrK.field_status = 4;
            this.lrK.field_errCode = d.lrT;
            e.b(this.lrK);
            this.lrJ.lsp.b(this.lrK.field_downloadId, this.lrK.field_errCode, false);
        }
    }
}
