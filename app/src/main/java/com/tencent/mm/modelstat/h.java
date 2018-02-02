package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    long beginTime;
    long endTime;
    boolean fLH;
    long hRA;
    long hRy;
    long hRz;
    int rtType;

    public h(int i, boolean z, long j) {
        this.rtType = i;
        this.fLH = z;
        this.hRy = j;
        this.hRz = 0;
    }

    public final void SW() {
        if (this.hRz == 0) {
            this.beginTime = bh.Wp();
            this.hRA = bh.Wq();
        }
        this.hRz++;
    }

    public final void br(long j) {
        if (this.hRy == 0) {
            this.hRy = j;
        }
        this.hRA = bh.Wq() - this.hRA;
        this.endTime = bh.Wp();
        x.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hRy + " Count:" + this.hRz + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
    }
}
