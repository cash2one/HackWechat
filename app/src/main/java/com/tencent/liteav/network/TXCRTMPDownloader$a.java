package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;

class TXCRTMPDownloader$a extends Thread {
    final /* synthetic */ TXCRTMPDownloader a;
    private long b = 0;
    private String c;
    private boolean d;

    TXCRTMPDownloader$a(TXCRTMPDownloader tXCRTMPDownloader, String str, boolean z) {
        this.a = tXCRTMPDownloader;
        super("RTMPDownLoad");
        this.c = str;
        this.d = z;
    }

    public void run() {
        synchronized (this) {
            this.b = TXCRTMPDownloader.access$000(this.a, this.c, this.d);
        }
        TXCRTMPDownloader.access$100(this.a, this.b);
        synchronized (this) {
            TXCRTMPDownloader.access$200(this.a, this.b);
            this.b = 0;
        }
    }

    public void a() {
        synchronized (this) {
            if (this.b != 0) {
                TXCRTMPDownloader.access$300(this.a, this.b);
            }
        }
    }

    public DownloadStats b() {
        DownloadStats downloadStats = null;
        synchronized (this) {
            if (this.b != 0) {
                downloadStats = TXCRTMPDownloader.access$400(this.a, this.b);
            }
        }
        return downloadStats;
    }
}
