package com.tencent.mm.modelfriend;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.m;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.as;
import java.util.Iterator;

public final class s extends k implements com.tencent.mm.network.k {
    public static a hwp;
    e gJT;
    private int hmS;
    public final q hnp;

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, 0, str3, str4);
        a aVar = (a) this.hnp.Kb();
        aVar.vBu.vMg = str5;
        aVar.vBu.vMh = str6;
    }

    public s(String str, int i, String str2, int i2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        ((a) this.hnp.Kb()).vBu.vJl = str4;
    }

    public s(String str, int i, String str2, int i2, String str3) {
        this.gJT = null;
        this.hmS = 2;
        this.hnp = new b();
        a aVar = (a) this.hnp.Kb();
        aVar.vBu.vJL = i;
        x.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.vBu.vMb = str;
        aVar.vBu.vMc = str2;
        aVar.vBu.vMd = i2;
        aVar.vBu.vMe = str3;
        aVar.vBu.lOo = w.cfi();
        aVar.vBu.vJz = com.tencent.mm.kernel.a.CB();
        if (bh.ov(aVar.vBu.vMg) && bh.ov(aVar.vBu.vMh)) {
            aVar.vBu.vMg = hwp != null ? hwp.Ol() : "";
            aVar.vBu.vMh = d.vAx;
        }
    }

    public final void hE(int i) {
        ((a) this.hnp.Kb()).vBu.vMj = i;
    }

    public final void hF(int i) {
        ((a) this.hnp.Kb()).vBu.vMk = i;
    }

    public final int IS() {
        return ((a) this.hnp.Kb()).vBu.vJL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = (a) this.hnp.Kb();
        if (aVar.vBu.vMb == null || aVar.vBu.vMb.length() <= 0) {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.vBu.vMb);
            return -1;
        } else if ((aVar.vBu.vJL != 6 && aVar.vBu.vJL != 9) || (aVar.vBu.vMc != null && aVar.vBu.vMc.length() > 0)) {
            return a(eVar, this.hnp, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.vBu.vMb);
            return -1;
        }
    }

    public final int getType() {
        return c.CTRL_INDEX;
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
        x.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        m.b bVar = (m.b) qVar.Hp();
        if (bVar == null || bVar.vBv == null) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", new Object[]{bVar});
        } else {
            int i4 = bVar.vBv.vJp;
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", new Object[]{Integer.valueOf(i4)});
            g.Dk();
            g.Dj().gQd.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Di().gPJ.hmV;
            if (eVar != null) {
                eVar.bH((i4 & 1) == 0);
            }
        }
        if (i2 == 4 && i3 == -301) {
            as.a(true, bVar.vBv.vMr, bVar.vBv.vMs, bVar.vBv.vMq);
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
            } else {
                a(this.hmA, this.gJT);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.hmS)});
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
            } else {
                a(this.hmA, this.gJT);
            }
        } else if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            g.Dm().F(new 1(this, r0));
        } else if (i2 == 0 && i3 == 0) {
            as.a(false, bVar.vBv.vMr, bVar.vBv.vMs, bVar.vBv.vMq);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jd(Og());
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final String NV() {
        return ((m.b) this.hnp.Hp()).vBv.vMp;
    }

    public final String getUsername() {
        return ((m.b) this.hnp.Hp()).vBv.vIy;
    }

    public final String NW() {
        return ((m.b) this.hnp.Hp()).vBv.frP;
    }

    public final String NX() {
        return ((m.b) this.hnp.Hp()).vBv.vJl;
    }

    public final String NY() {
        return ((m.b) this.hnp.Hp()).vBv.vMw;
    }

    public final int NZ() {
        return ((m.b) this.hnp.Hp()).vBv.vMl;
    }

    public final String Oa() {
        return ((m.b) this.hnp.Hp()).vBv.vMy;
    }

    public final String Ob() {
        return ((m.b) this.hnp.Hp()).vBv.vMz;
    }

    public final int Oc() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 6) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 3);
                }
            }
        }
        return 3;
    }

    public final int Od() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 4) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 30);
                }
            }
        }
        return 30;
    }

    public final int Oe() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 5) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                }
            }
        }
        return 0;
    }

    public final boolean Of() {
        int i;
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 7) {
                    i = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    private int Og() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 1) {
                    return bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                }
            }
        }
        return 0;
    }

    public final boolean Oh() {
        int i;
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 10) {
                    i = bh.getInt(com_tencent_mm_protocal_c_bmg.wPM, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final String Oi() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 14) {
                    return com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
        }
        return null;
    }

    public final String Oj() {
        bin com_tencent_mm_protocal_c_bin = ((m.b) this.hnp.Hp()).vBv.vJk;
        if (!(com_tencent_mm_protocal_c_bin == null || com_tencent_mm_protocal_c_bin.wLY == null || com_tencent_mm_protocal_c_bin.wLY.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_bin.wLY.iterator();
            while (it.hasNext()) {
                bmg com_tencent_mm_protocal_c_bmg = (bmg) it.next();
                if (com_tencent_mm_protocal_c_bmg.pQj == 15) {
                    return com_tencent_mm_protocal_c_bmg.wPM;
                }
            }
        }
        return null;
    }

    public final String Ok() {
        return ((m.b) this.hnp.Hp()).vBv.vMm;
    }

    public final void lb(String str) {
        ((a) this.hnp.Kb()).vBu.vMm = str;
    }
}
