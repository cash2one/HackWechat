package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.a;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends k implements com.tencent.mm.network.k {
    private g rSf;

    public abstract void aKF();

    public abstract void cy(int i, int i2);

    public abstract void d(int i, int i2, String str, q qVar);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rSf = new g(new a(this, (byte) 0));
        this.rSf.rSi = -3202;
        g gVar = this.rSf;
        if (i2 == 4 && i3 == -3200) {
            a.a(new b<c>(gVar) {
                final /* synthetic */ g rSj;

                {
                    this.rSj = r1;
                }

                public final /* synthetic */ void a(e eVar) {
                    c cVar = (c) eVar;
                    x.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.fnL);
                    if (!cVar.isSuccess()) {
                        com.tencent.mm.plugin.soter.c.a.dM(1, cVar.errCode);
                        if (this.rSj.rSh != null) {
                            this.rSj.rSh.xY(cVar.errCode);
                        }
                    } else if (this.rSj.rSh != null) {
                        this.rSj.rSh.bCK();
                    }
                }
            }, true, new e());
        } else if (i2 != 4 || i3 != gVar.rSi) {
            z = false;
        } else if (gVar.rSh != null) {
            gVar.rSh.bCK();
        }
        if (!z) {
            d(i2, i3, str, qVar);
        }
    }
}
