package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class p$b extends Thread {
    af handler;
    final /* synthetic */ p shm;

    public p$b(p pVar) {
        this.shm = pVar;
        this.handler = new 1(this, pVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (p.d(this.shm) == null) {
            x.e("MicroMsg.VoicePrintRecoder", "Stop Record Failed recorder == null");
            return;
        }
        synchronized (this.shm) {
            String aJ = m.aJ(p.e(this.shm), true);
            x.d("MicroMsg.VoicePrintRecoder", "fullPathName %s", new Object[]{aJ});
            this.shm.shj = aJ;
            if (p.f(this.shm) != null) {
                p.f(this.shm).requestFocus();
            }
            if (p.d(this.shm).cI(aJ)) {
                p.a(this.shm, bh.Wq());
                x.d("MicroMsg.VoicePrintRecoder", "Thread Started Record fileName[" + p.e(this.shm) + "]");
                this.handler.sendEmptyMessageDelayed(0, 1);
                return;
            }
            p.g(this.shm);
            x.d("MicroMsg.VoicePrintRecoder", "Thread Start Record  Error fileName[" + p.e(this.shm) + "]");
            p.d(this.shm).vi();
            p.h(this.shm);
            if (p.f(this.shm) != null) {
                p.f(this.shm).zd();
            }
            if (p.i(this.shm) != null) {
                p.i(this.shm).bFI();
            }
        }
    }
}
