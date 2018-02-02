package com.tencent.mm.e.b;

import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements a {
    final /* synthetic */ h flK;

    h$1(h hVar) {
        this.flK = hVar;
    }

    public final boolean uF() {
        q.a(this.flK.mFileName, this.flK);
        m.UF().run();
        x.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + this.flK.mFileName);
        return false;
    }
}
