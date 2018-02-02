package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ a gMn;
    final /* synthetic */ String gMo;
    final /* synthetic */ b gMp;

    b$2(b bVar, a aVar, String str) {
        this.gMp = bVar;
        this.gMn = aVar;
        this.gMo = str;
    }

    public final void run() {
        x.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", new Object[]{Integer.valueOf(this.gMn.hashCode()), Long.valueOf(Thread.currentThread().getId())});
        if (this.gMn.gMt) {
            synchronized (this.gMn) {
                if (this.gMn.gMt) {
                    this.gMn.gMt = false;
                    this.gMn.notifyAll();
                    this.gMn.gMu = null;
                    synchronized (b.a(this.gMp)) {
                        b.a(this.gMp).remove(this.gMo);
                    }
                    return;
                }
            }
        }
    }
}
