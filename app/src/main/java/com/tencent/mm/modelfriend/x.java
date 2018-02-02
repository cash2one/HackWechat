package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.t;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;

public final class x extends k implements com.tencent.mm.network.k {
    e gJT = null;
    public final q hnp = new a();

    public x(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        a aVar = (a) this.hnp.Kb();
        aVar.vBL.wnH = str;
        aVar.vBL.wnI = str2;
        aVar.vBL.kub = str3;
        aVar.vBL.wnJ = str4;
        aVar.vBL.wnK = str5;
        aVar.vBL.wnL = str6;
        aVar.vBL.wnM = i;
        aVar.vBL.lOo = w.cfi();
        aVar.vBL.vJz = ar.CB();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 429;
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 4 && i3 == -102) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            ar.Dm().F(new 1(this, r0));
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final byte[] Oo() {
        return n.a(((t.b) this.hnp.Hp()).vBM.wnN, new byte[0]);
    }

    public final String Op() {
        return ((t.b) this.hnp.Hp()).vBM.wnK;
    }
}
