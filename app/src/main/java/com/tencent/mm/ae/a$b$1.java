package com.tencent.mm.ae;

import com.tencent.mm.ae.a.a;
import com.tencent.mm.ae.a.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

class a$b$1 implements k {
    final /* synthetic */ b hmf;

    a$b$1(b bVar) {
        this.hmf = bVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.vending.g.b bVar = this.hmf.hmc;
        Object[] objArr = new Object[1];
        objArr[0] = a.a(i2, i3, str, (bdf) this.hmf.hmb.hmh.hmo, this.hmf, this.hmf.hmd);
        g.a(bVar, objArr);
        this.hmf.gOB.a(i2, i3, str, this.hmf.hma);
        x.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[]{Integer.valueOf(this.hmf.hma.hashCode()), Integer.valueOf(this.hmf.getType()), Long.valueOf(bh.Wp() - this.hmf.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }
}
