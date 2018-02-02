package com.tencent.mm.e.b;

import com.tencent.mm.ae.h.a;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.x;

class h$3 implements a {
    final /* synthetic */ h flK;

    h$3(h hVar) {
        this.flK = hVar;
    }

    public final void onError() {
        this.flK.flu.zd();
        x.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + this.flK.mFileName);
        q.nY(this.flK.mFileName);
        if (this.flK.flH != null) {
            this.flK.flH.onError();
        }
    }
}
