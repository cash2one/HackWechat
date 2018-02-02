package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ a qpB;

    a$3(a aVar) {
        this.qpB = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (this.qpB.qpu) {
            x.e("MicroMsg.MusicFingerPrintRecorder", "tryStartNetscene clientid: %d but netscene is running.", new Object[]{Integer.valueOf(this.qpB.qpw)});
            return;
        }
        synchronized (this.qpB.qpm) {
            if (this.qpB.qpn <= 0) {
                return;
            }
            Object obj = new byte[this.qpB.qpn];
            System.arraycopy(this.qpB.qpm, 0, obj, 0, this.qpB.qpn);
            this.qpB.qpn = 0;
            long j = this.qpB.qpp;
        }
    }

    public final String toString() {
        return super.toString() + "|tryStartNetscene";
    }
}
