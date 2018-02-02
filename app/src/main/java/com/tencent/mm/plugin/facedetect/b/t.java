package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends p implements k, e {
    private final q hnp = new g();
    private boolean mfl = false;
    private String mfq = "";

    public final boolean aGh() {
        return true;
    }

    public final String aGi() {
        return this.mfq;
    }

    public t(long j, String str, String str2) {
        a aVar = (a) this.hnp.Kb();
        aVar.mfg.wiX = p.mfr;
        aVar.mfg.wiY = j;
        aVar.mfg.wIc = str2;
        aVar.mfg.wIb = str;
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
        x.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        k.b bVar = (k.b) qVar.Hp();
        if (i == 0 && i2 == 0) {
            this.mfl = bVar.mfh.wIe == 0;
            this.mfq = bVar.mfh.wId;
            String str2 = "MicroMsg.NetSceneFaceVerifyFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.mfl);
            objArr[1] = Integer.valueOf(bVar.mfh.wIe);
            if (bh.ov(this.mfq)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
            i2 = bVar.mfh.wIe;
        } else if (!(bVar == null || bVar.mfh == null || bVar.mfh.wIe == 0)) {
            x.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i2 = bVar.mfh.wIe;
        }
        this.gJT.a(i, i2, str, this);
    }

    final void zH(String str) {
        ((a) this.hnp.Kb()).mfg.wiX = str;
    }

    protected final asy g(q qVar) {
        return ((k.b) qVar.Hp()).mfh.wja;
    }
}
