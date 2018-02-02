package com.tencent.mm.modelfriend;

import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class t extends k implements com.tencent.mm.network.k {
    private String fxT;
    private String fxV;
    public final b gJQ;
    private e gJT;
    private int hmS;

    public t(String str, int i, String str2, String str3, String str4, String str5) {
        this(str, i, str2, 0, str3);
        this.fxT = str4;
        this.fxV = str5;
        gx gxVar = (gx) this.gJQ.hmg.hmo;
        gxVar.vMg = str4;
        gxVar.vMh = str5;
    }

    public t(String str, int i, String str2, int i2, String str3) {
        this.gJT = null;
        this.hmS = 2;
        this.fxT = null;
        this.fxV = null;
        a aVar = new a();
        aVar.hmj = new gx();
        aVar.hmk = new gy();
        aVar.uri = "/cgi-bin/micromsg-bin/bindopmobile";
        aVar.hmi = 132;
        aVar.hml = 45;
        aVar.hmm = 1000000045;
        this.gJQ = aVar.JZ();
        gx gxVar = (gx) this.gJQ.hmg.hmo;
        gxVar.vJL = i;
        gxVar.vMd = i2;
        gxVar.vMe = str3;
        if (bh.ov(this.fxT) && bh.ov(this.fxV)) {
            gxVar.vMg = f.xeD ? ac.getContext().getString(R.l.eGF) : ac.getContext().getString(R.l.eGE);
            gxVar.vMh = d.vAx;
        }
        if (str != null && str.length() > 0 && (i == 1 || i == 4 || i == 18)) {
            ar.Hg();
            c.CU().set(4097, str);
        } else if (i == 2 || i == 19) {
            ar.Hg();
            str = (String) c.CU().get(4097, null);
        } else if (i == 3) {
            ar.Hg();
            str = (String) c.CU().get(6, null);
        }
        x.d("MicroMsg.NetSceneBindOpMobile", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        gxVar.vMb = str;
        gxVar.vMc = str2;
        gxVar.lOo = w.cfi();
    }

    public final int IS() {
        return ((gx) this.gJQ.hmg.hmo).vJL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        gx gxVar = (gx) this.gJQ.hmg.hmo;
        if (gxVar.vMb == null || gxVar.vMb.length() <= 0) {
            x.e("MicroMsg.NetSceneBindOpMobile", "doScene getMobile Error: " + gxVar.vMb);
            return -1;
        } else if ((gxVar.vJL != 2 && gxVar.vJL != 19) || (gxVar.vMc != null && gxVar.vMc.length() > 0)) {
            return a(eVar, this.gJQ, this);
        } else {
            x.e("MicroMsg.NetSceneBindOpMobile", "doScene getVerifyCode Error: " + gxVar.vMb);
            return -1;
        }
    }

    public final int getType() {
        return 132;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        gx gxVar = (gx) this.gJQ.hmg.hmo;
        gy gyVar = (gy) this.gJQ.hmh.hmo;
        if (gyVar != null) {
            int i4 = gyVar.vJp;
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop:%s", new Object[]{Integer.valueOf(i4)});
            g.Dk();
            g.Dj().gQd.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Di().gPJ.hmV;
            if (eVar != null) {
                eVar.bH((i4 & 1) == 0);
            }
        } else {
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth mmtls bindop not set as ret:%s", new Object[]{gyVar});
        }
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " sms:" + gyVar.vMn + "safedevice status = " + gyVar.vFx);
            if (gxVar.vJL == 2 || gxVar.vJL == 4 || gxVar.vJL == 11 || gxVar.vJL == 19) {
                ar.Hg();
                c.CU().set(4097, "");
                ar.Hg();
                c.CU().set(6, gxVar.vMb);
                if (bh.ov(this.fxT) || bh.ov(this.fxV)) {
                    m.NK();
                }
                if (!(bh.ov(this.fxT) || bh.ov(this.fxV))) {
                    com.tencent.mm.sdk.b.b rzVar = new rz();
                    rzVar.fJI.fJJ = gyVar;
                    com.tencent.mm.sdk.b.a.xef.m(rzVar);
                    ar.Hg();
                    c.CU().set(64, Integer.valueOf(gyVar.vFx));
                    com.tencent.mm.sdk.b.b saVar = new sa();
                    saVar.fJK.fJL = true;
                    saVar.fJK.fJM = true;
                    com.tencent.mm.sdk.b.a.xef.m(saVar);
                }
                if (gxVar.vJL == 19) {
                    ar.Hg();
                    c.CU().set(12322, null);
                }
                x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile binded");
            } else if (gxVar.vJL == 3) {
                ar.Hg();
                c.CU().set(4097, "");
                ar.Hg();
                c.CU().set(6, "");
                ar.Hg();
                c.CU().set(12322, null);
                ar.Hg();
                c.CU().set(64, Integer.valueOf(gyVar.vFx));
                com.tencent.mm.sdk.b.b saVar2 = new sa();
                saVar2.fJK.fJL = false;
                saVar2.fJK.fJM = true;
                com.tencent.mm.sdk.b.a.xef.m(saVar2);
                m.NR();
                m.NS();
                x.d("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  mobile unbinded");
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBindOpMobile", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneBindOpMobile", "summerauth bindop MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", new Object[]{Integer.valueOf(this.hmS)});
            this.hmS--;
            if (this.hmS <= 0) {
                this.gJT.a(3, -1, "", this);
                return;
            } else {
                a(this.hmA, this.gJT);
                return;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
