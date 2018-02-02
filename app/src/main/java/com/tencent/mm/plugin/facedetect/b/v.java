package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.k.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends p implements k, b {
    private final q hnp = new h();
    private long mfw = -1;
    private byte[] mfx = null;

    public final long aGf() {
        return this.mfw;
    }

    public final byte[] aGg() {
        return this.mfx;
    }

    public v(int i) {
        a aVar = (a) this.hnp.Kb();
        aVar.mfc.wiX = p.mfr;
        aVar.mfc.ktN = 1;
        aVar.mfc.rYW = i;
    }

    final int g(e eVar) {
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
        return 733;
    }

    public final void c(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            i.b bVar = (i.b) qVar.Hp();
            this.mfw = bVar.mfd.wiY;
            if (bVar.mfd.wiZ != null) {
                this.mfx = bVar.mfd.wiZ.oz;
            }
            if (bVar.mfd.wjb != null) {
                byte[] bArr;
                byte[] bArr2;
                if (bVar.mfd.wjb.vSG == null || bVar.mfd.wjb.vSG.wJB <= 0) {
                    bArr = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[]{Integer.valueOf(bVar.mfd.wjb.vSG.wJB)});
                    bArr = n.a(bVar.mfd.wjb.vSG);
                }
                if (bVar.mfd.wjb.vSH == null || bVar.mfd.wjb.vSH.wJB <= 0) {
                    bArr2 = null;
                } else {
                    x.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[]{Integer.valueOf(bVar.mfd.wjb.vSH.wJB)});
                    bArr2 = n.a(bVar.mfd.wjb.vSH);
                }
                g.MK().a(bVar.mfd.wjb.vSD, bVar.mfd.wjb.vSE, bVar.mfd.wjb.vSF, bArr, bArr2, bVar.mfd.wjb.vSI);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.mfw);
            objArr[1] = Integer.valueOf(this.mfx == null ? 0 : this.mfx.length);
            x.i(str2, str3, objArr);
        }
        this.gJT.a(i, i2, str, this);
    }

    final void zH(String str) {
        ((a) this.hnp.Kb()).mfc.wiX = str;
    }

    protected final asy g(q qVar) {
        return ((i.b) qVar.Hp()).mfd.wja;
    }
}
