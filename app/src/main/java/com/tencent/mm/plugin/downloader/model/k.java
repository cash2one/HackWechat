package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

final class k extends j {
    public k(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (bh.ov(gVar.iFI)) {
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(gVar.iFI));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            ac.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            return -1;
        }
    }

    public final int bX(long j) {
        return 1;
    }

    public final FileDownloadTaskInfo bY(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.status = -1;
        return fileDownloadTaskInfo;
    }

    public final boolean bZ(long j) {
        return false;
    }

    public final boolean ca(long j) {
        return false;
    }
}
