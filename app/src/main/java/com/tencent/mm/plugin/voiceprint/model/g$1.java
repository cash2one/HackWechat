package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ int hwq;
    final /* synthetic */ g sgN;

    g$1(g gVar, int i) {
        this.sgN = gVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(this.sgN.hmA, new e(this) {
            final /* synthetic */ g$1 sgO;

            {
                this.sgO = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 0 && i2 == 0) {
                    this.sgO.sgN.a(this.sgO.sgN.hmA, this.sgO.sgN.gJT);
                } else {
                    this.sgO.sgN.gJT.a(i, i2, "", this.sgO.sgN);
                }
            }
        });
    }
}
