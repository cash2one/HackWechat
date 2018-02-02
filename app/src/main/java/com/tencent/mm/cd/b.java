package com.tencent.mm.cd;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private final byte[] gOg = new byte[1];
    private long zJS = -1;

    public final void cCp() {
        synchronized (this.gOg) {
            if (this.gOg[0] == (byte) 0) {
                this.gOg[0] = (byte) 1;
                this.zJS = Thread.currentThread().getId();
                j.i("MicroMsg.WxConsumedLock", "lock %s", this);
            } else {
                try {
                    if (this.zJS != Thread.currentThread().getId()) {
                        j.i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                        this.gOg.wait();
                        j.i("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                    } else {
                        j.i("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WxConsumedLock", e, "", new Object[0]);
                }
            }
        }
    }

    public final void done() {
        synchronized (this.gOg) {
            if (this.gOg[0] != (byte) 0) {
                this.gOg[0] = (byte) 0;
                this.zJS = -1;
                this.gOg.notifyAll();
                j.i("MicroMsg.WxConsumedLock", "notify done %s", this);
            }
        }
    }
}
