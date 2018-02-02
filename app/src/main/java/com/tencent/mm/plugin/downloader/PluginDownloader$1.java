package com.tencent.mm.plugin.downloader;

import android.database.Cursor;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class PluginDownloader$1 implements Runnable {
    final /* synthetic */ PluginDownloader lqZ;

    PluginDownloader$1(PluginDownloader pluginDownloader) {
        this.lqZ = pluginDownloader;
    }

    public final void run() {
        Object obj = null;
        b Fe = e.Fe();
        if (Fe != null) {
            x.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
            Cursor rawQuery = Fe.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
            if (rawQuery == null) {
                x.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
            } else {
                obj = new LinkedList();
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.b(rawQuery);
                    obj.add(aVar);
                }
                rawQuery.close();
            }
        }
        if (!bh.cA(obj)) {
            Iterator it = obj.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                x.i("MicroMsg.PluginDownloader", "download fail, appId: " + aVar2.field_appId);
                aVar2.field_status = 4;
                aVar2.field_errCode = d.lrX;
                e.c(aVar2);
                f aAd = f.aAd();
                long j = aVar2.field_downloadId;
                int i = aVar2.field_errCode;
                if (aAd.lsp != null) {
                    aAd.lsp.b(j, i, false);
                }
            }
        }
    }
}
