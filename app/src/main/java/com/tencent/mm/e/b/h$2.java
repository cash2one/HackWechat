package com.tencent.mm.e.b;

import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ h flK;

    h$2(h hVar) {
        this.flK = hVar;
    }

    public final void run() {
        if (!this.flK.flC) {
            x.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
            this.flK.vz();
        }
    }
}
