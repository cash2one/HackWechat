package com.tencent.liteav.network;

import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.network.TXCStreamDownloader.DownloadStats;
import java.util.Vector;

public abstract class TXIStreamDownloader {
    public int connectRetryInterval = 3;
    public int connectRetryLimit = 3;
    public int connectRetryTimes = 0;
    protected boolean mIsRunning = false;
    protected e mListener = null;
    protected a mNotifyListener = null;

    public abstract void startDownload(Vector<d> vector, boolean z, boolean z2);

    public abstract void stopDownload();

    public void setListener(e eVar) {
        this.mListener = eVar;
    }

    public void setNotifyListener(a aVar) {
        this.mNotifyListener = aVar;
    }

    public void sendNotifyEvent(int i) {
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, null);
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (this.mListener != null) {
            b bVar = new b();
            bVar.a = bArr;
            bVar.b = i;
            bVar.h = j;
            bVar.g = j2;
            bVar.i = i2;
            this.mListener.onPullNAL(bVar);
        }
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (this.mListener != null) {
            com.tencent.liteav.basic.f.a aVar = new com.tencent.liteav.basic.f.a();
            aVar.f = bArr;
            aVar.e = (long) i;
            if (i2 == 10) {
                if (i3 == 1) {
                    aVar.d = com.tencent.liteav.basic.a.a.k;
                } else {
                    aVar.d = com.tencent.liteav.basic.a.a.l;
                }
                if (aVar.d == com.tencent.liteav.basic.a.a.k) {
                    aVar.c = com.tencent.liteav.basic.a.a.h;
                }
            }
            if (i2 == 2) {
                aVar.d = com.tencent.liteav.basic.a.a.m;
            }
            this.mListener.onPullAudio(aVar);
        }
    }

    public DownloadStats getDownloadStats() {
        return null;
    }

    public String getCurrentStreamUrl() {
        return null;
    }

    public boolean isQuicChannel() {
        return false;
    }

    public int getConnectCountQuic() {
        return 0;
    }

    public int getConnectCountTcp() {
        return 0;
    }
}
