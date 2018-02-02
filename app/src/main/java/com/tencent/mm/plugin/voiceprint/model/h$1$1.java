package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voiceprint.model.h.1;
import com.tencent.mm.sdk.platformtools.x;

class h$1$1 implements e {
    final /* synthetic */ 1 sgR;

    h$1$1(1 1) {
        this.sgR = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.sgR.sgQ.a(this.sgR.sgQ.hmA, this.sgR.sgQ.gJT);
        } else {
            this.sgR.sgQ.gJT.a(i, i2, "", this.sgR.sgQ);
        }
    }
}
