package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class p extends l implements k {
    static String mfr = null;
    protected e gJT = null;

    abstract void c(int i, int i2, String str, q qVar);

    abstract int g(com.tencent.mm.network.e eVar);

    protected abstract asy g(q qVar);

    abstract void zH(String str);

    protected static String NW() {
        return mfr;
    }

    public static void zI(String str) {
        mfr = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (bh.ov(mfr)) {
            return getType();
        }
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", new Object[]{mfr});
        zH(mfr);
        return g(eVar);
    }

    public final il c(q qVar) {
        asy g = g(qVar);
        if (g != null) {
            return g.vMr;
        }
        return null;
    }

    public final asx d(q qVar) {
        asy g = g(qVar);
        if (g != null) {
            return g.vMs;
        }
        return null;
    }

    public final aki e(q qVar) {
        asy g = g(qVar);
        if (g != null) {
            return g.vMq;
        }
        return null;
    }

    public final void Kj() {
        if (this.gJT != null) {
            this.gJT.a(3, -1, "", this);
        }
    }

    public final e Kk() {
        return this.gJT;
    }

    public final void a(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 4 && i2 == -102) {
            x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            g.Dm().F(new 1(this, r0));
            return;
        }
        c(i, i2, str, qVar);
    }
}
