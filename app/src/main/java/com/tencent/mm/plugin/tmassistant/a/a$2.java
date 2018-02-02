package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ long lrL;
    final /* synthetic */ a sdR;

    a$2(a aVar, long j) {
        this.sdR = aVar;
        this.lrL = j;
    }

    public final void run() {
        a ce = e.ce(this.lrL);
        if (ce != null) {
            try {
                a.a(this.sdR).cancelDownloadTask(ce.field_downloadUrl);
                b.deleteFile(ce.field_filePath);
                this.sdR.sdL.remove(Long.valueOf(ce.field_downloadId));
                this.sdR.cancelNotification(ce.field_downloadUrl);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: status = " + ce.field_status);
                if (ce.field_status != 5) {
                    e.j(ce.field_downloadId, 5);
                    a.a(this.sdR, 5, ce.field_downloadId);
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", new Object[]{Long.valueOf(this.lrL), ce.field_filePath});
                }
            } catch (Exception e) {
                x.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
            }
        }
    }
}
