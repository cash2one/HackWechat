package com.tencent.liteav.network;

import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f.a;
import java.util.Iterator;
import java.util.Vector;

class TXCStreamDownloader$1 implements a {
    final /* synthetic */ String a;
    final /* synthetic */ TXCStreamDownloader b;

    TXCStreamDownloader$1(TXCStreamDownloader tXCStreamDownloader, String str) {
        this.b = tXCStreamDownloader;
        this.a = str;
    }

    public void a(int i, String str, Vector<d> vector) {
        if (i != 0 || vector == null || vector.isEmpty()) {
            this.b.onNotifyEvent(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_GET_RTMP_ACC_URL_FAIL, null);
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$500(this.b), com.tencent.liteav.basic.datareport.a.as, i, str);
            TXCLog.e(TXCStreamDownloader.TAG, "getAccelerateStreamPlayUrl failed, play stream with raw url");
            if (TXCStreamDownloader.access$000(this.b)) {
                TXCStreamDownloader.access$600(this.b, this.a);
                if (TXCStreamDownloader.access$200(this.b) != null) {
                    TXCStreamDownloader.access$200(this.b).postDelayed(TXCStreamDownloader.access$300(this.b), 2000);
                }
            }
        } else if (TXCStreamDownloader.access$000(this.b)) {
            if (TXCStreamDownloader.access$100(this.b) != null) {
                Iterator it = vector.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    int i3;
                    d dVar = (d) it.next();
                    if (dVar == null || !dVar.b || dVar.a == null || dVar.a.length() <= 0) {
                        i3 = i2;
                    } else {
                        i3 = i2 + 1;
                    }
                    i2 = i3;
                }
                this.b.setStatusValue(7116, Long.valueOf((long) i2));
                this.b.setStatusValue(7112, Long.valueOf(2));
                TXCStreamDownloader.access$100(this.b).startDownload(vector, true, true);
            }
            if (TXCStreamDownloader.access$200(this.b) != null) {
                TXCStreamDownloader.access$200(this.b).postDelayed(TXCStreamDownloader.access$300(this.b), 2000);
            }
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$500(this.b), com.tencent.liteav.basic.datareport.a.as, i, TXCStreamDownloader.access$400(this.b).b());
        } else {
            TXCDRApi.txReportDAU(TXCStreamDownloader.access$500(this.b), com.tencent.liteav.basic.datareport.a.as, -4, "livePlayer have been stopped");
        }
    }
}
