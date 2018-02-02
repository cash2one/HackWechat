package com.tencent.mm.plugin.emoji.sync;

import android.net.TrafficStats;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class BKGLoaderManager$1 implements a {
    final /* synthetic */ BKGLoaderManager lzX;

    BKGLoaderManager$1(BKGLoaderManager bKGLoaderManager) {
        this.lzX = bKGLoaderManager;
    }

    public final boolean uF() {
        if (this.lzX.lzE || this.lzX.lzF || this.lzX.lzG) {
            long uidTxBytes = TrafficStats.getUidTxBytes(this.lzX.hzu);
            long uidRxBytes = TrafficStats.getUidRxBytes(this.lzX.hzu);
            long j = (uidTxBytes - this.lzX.lzS) + (uidRxBytes - this.lzX.lzT);
            x.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
            if (j <= 20480) {
                this.lzX.aBZ();
            } else {
                this.lzX.lzS = uidTxBytes;
                this.lzX.lzT = uidRxBytes;
                this.lzX.lzU.J(1000, 1000);
            }
        }
        return false;
    }
}
