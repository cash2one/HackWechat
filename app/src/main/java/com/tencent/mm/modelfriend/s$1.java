package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.sdk.platformtools.x;

class s$1 implements Runnable {
    final /* synthetic */ int hwq;
    final /* synthetic */ s hwr;

    s$1(s sVar, int i) {
        this.hwr = sVar;
        this.hwq = i;
    }

    public final void run() {
        new m().a(this.hwr.hmA, new e(this) {
            final /* synthetic */ s$1 hws;

            {
                this.hws = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                if (i == 0 && i2 == 0) {
                    this.hws.hwr.a(this.hws.hwr.hmA, this.hws.hwr.gJT);
                } else {
                    this.hws.hwr.gJT.a(i, i2, "", this.hws.hwr);
                }
            }
        });
    }
}
