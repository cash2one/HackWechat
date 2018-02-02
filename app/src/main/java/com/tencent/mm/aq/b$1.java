package com.tencent.mm.aq;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b hzz;

    b$1(b bVar) {
        this.hzz = bVar;
    }

    public final boolean uF() {
        long uidRxBytes = TrafficStats.getUidRxBytes(this.hzz.hzu);
        long uidTxBytes = TrafficStats.getUidTxBytes(this.hzz.hzu);
        long j = (uidRxBytes - this.hzz.hzs) + (uidTxBytes - this.hzz.hzt);
        x.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / 1024));
        if (j <= 20480) {
            this.hzz.hzr = false;
            this.hzz.start();
        } else {
            this.hzz.hzs = uidRxBytes;
            this.hzz.hzt = uidTxBytes;
            this.hzz.hzw.J(1000, 1000);
        }
        return true;
    }
}
