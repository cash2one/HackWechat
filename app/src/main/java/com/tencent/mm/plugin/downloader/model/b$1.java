package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import com.tencent.mm.plugin.downloader.d.b;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements b {
    final /* synthetic */ b lrJ;

    b$1(b bVar) {
        this.lrJ = bVar;
    }

    public final void e(String str, int i, int i2, String str2) {
        a xH = e.xH(str);
        if (xH == null) {
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
            return;
        }
        x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        switch (i) {
            case 3:
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.lsG, 1);
                intent.setClass(b.a(this.lrJ), FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, xH.field_downloadId);
                try {
                    b.a(this.lrJ).startService(intent);
                } catch (Exception e) {
                    x.e("MicroMsg.FileCDNDownloader", e.getMessage());
                }
                b.a(this.lrJ, xH.field_downloadUrl);
                return;
            case 4:
                xH.field_errCode = Math.abs(i2);
                xH.field_status = 4;
                e.c(xH);
                this.lrJ.lsp.b(xH.field_downloadId, Math.abs(i2), false);
                b.a(this.lrJ, xH.field_downloadUrl, 4, 0, false);
                return;
            default:
                return;
        }
    }

    public final void j(String str, long j, long j2) {
        a xH = e.xH(str);
        if (xH == null) {
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
            return;
        }
        Long l = (Long) b.b(this.lrJ).get(xH.field_downloadUrl);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l == null || valueOf.longValue() - l.longValue() >= 500) {
            b.b(this.lrJ).put(xH.field_downloadUrl, valueOf);
            xH.field_status = 1;
            xH.field_downloadedSize = j;
            xH.field_totalSize = j2;
            e.c(xH);
            this.lrJ.lsp.cd(xH.field_downloadId);
            int i = 0;
            if (j2 > 0) {
                i = (int) ((((float) j) / ((float) j2)) * 100.0f);
            }
            if (i < 0) {
                i = 0;
            } else if (i > 100) {
                i = 100;
            }
            b.a(this.lrJ, xH.field_downloadUrl, 1, i, false);
        }
    }
}
