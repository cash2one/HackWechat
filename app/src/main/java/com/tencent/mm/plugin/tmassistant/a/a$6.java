package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class a$6 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ long lrL;
    final /* synthetic */ a sdR;

    a$6(a aVar, a aVar2, long j) {
        this.sdR = aVar;
        this.lrK = aVar2;
        this.lrL = j;
    }

    public final void run() {
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.sdR).getDownloadTaskState(this.lrK.field_downloadUrl);
            if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                a.a(this.sdR).pauseDownloadTask(this.lrK.field_downloadUrl);
                e.j(this.lrK.field_downloadId, 2);
                a.a(this.sdR, 2, this.lrK.field_downloadId);
                this.sdR.sdL.remove(Long.valueOf(this.lrK.field_downloadId));
                this.sdR.cancelNotification(this.lrK.field_downloadUrl);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[]{Long.valueOf(this.lrL)});
            }
        } catch (Throwable e) {
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
        }
    }
}
