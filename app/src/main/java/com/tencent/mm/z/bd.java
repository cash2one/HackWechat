package com.tencent.mm.z;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class bd extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final a hgZ;
    private final String hha;
    private long hhb;

    public interface a {
        void a(com.tencent.mm.network.e eVar);
    }

    public bd(a aVar) {
        this(aVar, null);
    }

    public bd(a aVar, String str) {
        x.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, bh.cgy());
        this.hgZ = aVar;
        this.hha = str;
    }

    public final int getType() {
        return 0;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        c(eVar);
        this.gJT = eVar2;
        this.hhb = bh.Wq();
        g.Dm().F(new Runnable(this) {
            final /* synthetic */ bd hhc;

            {
                this.hhc = r1;
            }

            public final void run() {
                this.hhc.a(0, 0, 0, null, null, null);
            }

            public final String toString() {
                return super.toString() + "|doScene";
            }
        });
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.hgZ != null) {
            x.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.hha, Long.valueOf(bh.bA(this.hhb)));
            this.hgZ.a(this.hmA);
        }
        this.gJT.a(0, 0, null, this);
    }
}
