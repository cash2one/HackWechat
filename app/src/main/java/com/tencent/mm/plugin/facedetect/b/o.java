package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends p implements k, e {
    private final q hnp = new f();
    private boolean mfl = false;
    private String mfq = "";

    public final boolean aGh() {
        return true;
    }

    public final String aGi() {
        return this.mfq;
    }

    public o(long j, String str, String str2) {
        a aVar = (a) this.hnp.Kb();
        aVar.mfe.wiX = p.mfr;
        aVar.mfe.wiY = j;
        aVar.mfe.wIb = str;
        aVar.mfe.wIc = str2;
    }

    final int g(e eVar) {
        this.hnp.Kb();
        return a(eVar, this.hnp, this);
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(com.tencent.mm.ae.k.a aVar) {
    }

    public final int getType() {
        return 930;
    }

    public final void c(int i, int i2, String str, q qVar) {
        boolean z = true;
        x.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        j.b bVar = (j.b) qVar.Hp();
        if (i == 0 && i2 == 0) {
            this.mfl = bVar.mff.wIe == 0;
            this.mfq = bVar.mff.wId;
            i2 = bVar.mff.wIe;
            String str2 = "MicroMsg.NetSceneFaceRegFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.mfl);
            objArr[1] = Integer.valueOf(bVar.mff.wIe);
            if (bh.ov(this.mfq)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        } else if (!(bVar == null || bVar.mff == null || bVar.mff.wIe == 0)) {
            x.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i2 = bVar.mff.wIe;
        }
        this.gJT.a(i, i2, str, this);
    }

    final void zH(String str) {
        ((a) this.hnp.Kb()).mfe.wiX = str;
    }

    protected final asy g(q qVar) {
        return ((j.b) qVar.Hp()).mff.wja;
    }
}
