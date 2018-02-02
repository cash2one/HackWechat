package com.tencent.mm.plugin.tmassistant.a;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

class a$1 implements Runnable {
    final /* synthetic */ a lrK;
    final /* synthetic */ g lsN;
    final /* synthetic */ String sdO;
    final /* synthetic */ long sdP;
    final /* synthetic */ boolean sdQ;
    final /* synthetic */ a sdR;
    final /* synthetic */ String val$url;

    a$1(a aVar, g gVar, a aVar2, String str, String str2, long j, boolean z) {
        this.sdR = aVar;
        this.lsN = gVar;
        this.lrK = aVar2;
        this.val$url = str;
        this.sdO = str2;
        this.sdP = j;
        this.sdQ = z;
    }

    public final void run() {
        int startDownloadTask;
        Exception e;
        if (this.lsN.lsB) {
            this.lrK.field_md5 = h.xP(this.lrK.field_downloadUrl);
        }
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = a.a(this.sdR).getDownloadTaskState(this.val$url);
            if (downloadTaskState != null && downloadTaskState.mState == 4) {
                a.xQ(downloadTaskState.mSavePath);
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "Previous task file removed: %s, %s", new Object[]{downloadTaskState.mUrl, downloadTaskState.mSavePath});
            }
            a.a(this.sdR).cancelDownloadTask(this.val$url);
            startDownloadTask = a.a(this.sdR).startDownloadTask(this.val$url, this.sdO, this.sdP, 0, "resource/tm.android.unknown", ab.UZ(this.val$url), this.sdQ, this.sdR.sdM);
            TMAssistantDownloadTaskInfo downloadTaskState2;
            if (startDownloadTask == 0) {
                try {
                    downloadTaskState2 = a.a(this.sdR).getDownloadTaskState(this.val$url);
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", new Object[]{this.val$url, downloadTaskState2.mSavePath, Integer.valueOf(e.bN(downloadTaskState2.mSavePath)), Long.valueOf(downloadTaskState2.mReceiveDataLen)});
                    this.lrK.field_startSize = downloadTaskState2.mReceiveDataLen;
                    this.lrK.field_filePath = downloadTaskState2.mSavePath;
                    this.lrK.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                    this.lrK.field_totalSize = downloadTaskState2.mTotalDataLen;
                    com.tencent.mm.plugin.downloader.model.e.c(this.lrK);
                    this.sdR.sdL.add(Long.valueOf(this.lrK.field_downloadId));
                    a.a(this.sdR, this.val$url, downloadTaskState2.mState, 0, true);
                    a aVar = this.sdR;
                    a.a(1, this.lrK.field_downloadId, downloadTaskState2.mSavePath);
                    x.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[]{Long.valueOf(this.lrK.field_downloadId), this.val$url, this.lrK.field_filePath});
                    return;
                } catch (Exception e2) {
                    e = e2;
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{e.toString()});
                    this.lrK.field_errCode = d.lrR;
                    this.lrK.field_status = 4;
                    com.tencent.mm.plugin.downloader.model.e.c(this.lrK);
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(startDownloadTask), this.val$url});
                    a.a(this.sdR, this.lrK.field_downloadId, d.lrR, false);
                }
            }
            if (startDownloadTask == 4) {
                x.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
                downloadTaskState2 = a.a(this.sdR).getDownloadTaskState(this.val$url);
                this.lrK.field_filePath = downloadTaskState2.mSavePath;
                this.lrK.field_startSize = downloadTaskState2.mReceiveDataLen;
                this.lrK.field_downloadedSize = downloadTaskState2.mReceiveDataLen;
                this.lrK.field_totalSize = downloadTaskState2.mTotalDataLen;
                com.tencent.mm.plugin.downloader.model.e.c(this.lrK);
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.lsG, 1);
                intent.setClass(this.sdR.mContext, FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, this.lrK.field_downloadId);
                try {
                    this.sdR.mContext.startService(intent);
                } catch (Exception e3) {
                    x.e("MicroMsg.FileDownloaderImplTMAssistant", e3.getMessage());
                }
                this.sdR.cancelNotification(this.val$url);
                this.sdR.sdL.remove(Long.valueOf(this.lrK.field_downloadId));
                return;
            }
            this.lrK.field_errCode = d.lrR;
            this.lrK.field_status = 4;
            com.tencent.mm.plugin.downloader.model.e.c(this.lrK);
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(startDownloadTask), this.val$url});
            a.a(this.sdR, this.lrK.field_downloadId, d.lrR, false);
        } catch (Exception e4) {
            e3 = e4;
            startDownloadTask = -1;
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{e3.toString()});
            this.lrK.field_errCode = d.lrR;
            this.lrK.field_status = 4;
            com.tencent.mm.plugin.downloader.model.e.c(this.lrK);
            x.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(startDownloadTask), this.val$url});
            a.a(this.sdR, this.lrK.field_downloadId, d.lrR, false);
        }
    }
}
