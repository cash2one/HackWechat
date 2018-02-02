package com.tencent.mm.e.b;

import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class h$a implements Runnable {
    final /* synthetic */ h flK;
    af handler;

    public h$a(h hVar) {
        this.flK = hVar;
        this.handler = new 1(this, hVar);
    }

    public final void run() {
        boolean z = true;
        synchronized (this.flK) {
            if (this.flK.flt == null) {
                x.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                return;
            }
            String str = this.flK.mFileName;
            if (this.flK.flD) {
                z = false;
            }
            x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[]{q.M(str, z), Boolean.valueOf(this.flK.flD)});
            if (this.flK.flt.cI(q.M(str, z))) {
                this.flK.flu.requestFocus();
            } else {
                q.nY(this.flK.mFileName);
                this.flK.mFileName = null;
                this.flK.flt = null;
                x.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + this.flK.mFileName + "]");
            }
            this.flK.flA = bh.Wq();
            x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + this.flK.mFileName + "] time:" + bh.bA(this.flK.flz));
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }
}
