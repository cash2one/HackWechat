package com.tencent.mm.plugin.downloader.d;

import com.tencent.mm.plugin.downloader.a.b.a;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.sdk.platformtools.x;

class a$4 extends a {
    final /* synthetic */ a lrq;

    a$4(a aVar) {
        this.lrq = aVar;
    }

    public final void d(String str, int i, int i2, String str2) {
        x.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (i != 1) {
            this.lrq.lrk.remove(new CDNTaskInfo(str));
        }
        if (this.lrq.lrl != null) {
            this.lrq.lrl.e(str, i, i2, str2);
        }
    }

    public final void i(String str, long j, long j2) {
        x.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        if (this.lrq.lrl != null) {
            this.lrq.lrl.j(str, j, j2);
        }
    }
}
