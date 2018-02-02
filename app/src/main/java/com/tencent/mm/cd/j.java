package com.tencent.mm.cd;

public final class j {
    public final byte[] gOg = new byte[1];

    public final void done() {
        synchronized (this.gOg) {
            if (this.gOg[0] == (byte) -1) {
                this.gOg[0] = (byte) 1;
                this.gOg.notifyAll();
                com.tencent.mm.kernel.j.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[]{this});
            }
        }
    }
}
