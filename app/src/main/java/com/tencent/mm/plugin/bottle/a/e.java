package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvoice.a;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aun;
import com.tencent.mm.protocal.c.auo;
import com.tencent.mm.protocal.c.pa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class e extends k implements com.tencent.mm.network.k {
    private String fileName = "";
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private String kAK = "";
    private int kAL = 0;
    private a kAM = null;
    private int msgType = 0;

    public e(String str, int i) {
        b.a aVar = new b.a();
        aVar.hmj = new aun();
        aVar.hmk = new auo();
        aVar.uri = "/cgi-bin/micromsg-bin/openbottle";
        aVar.hmi = 156;
        aVar.hml = 55;
        aVar.hmm = 1000000055;
        this.gJQ = aVar.JZ();
        this.kAK = str;
        this.msgType = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        aun com_tencent_mm_protocal_c_aun = (aun) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aun.ngq = this.msgType;
        com_tencent_mm_protocal_c_aun.wCw = this.kAK;
        if (com_tencent_mm_protocal_c_aun.wCx == null) {
            com_tencent_mm_protocal_c_aun.wCx = new pa();
        }
        if (com_tencent_mm_protocal_c_aun.wCy == null) {
            com_tencent_mm_protocal_c_aun.wCy = new pa();
        }
        if (this.msgType == 1) {
            com_tencent_mm_protocal_c_aun.wCx.vIC = 0;
            com_tencent_mm_protocal_c_aun.wCx.vYa = 0;
        } else if (this.msgType != 3) {
            x.e("MicroMsg.NetSceneOpenBottle", "doScene Error Msg type" + this.msgType);
            return -1;
        }
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        aun com_tencent_mm_protocal_c_aun = (aun) ((b) qVar).hmg.hmo;
        if (com_tencent_mm_protocal_c_aun.ngq == 1) {
            return k.b.hmP;
        }
        if (com_tencent_mm_protocal_c_aun.ngq != 3) {
            return k.b.hmQ;
        }
        if (com_tencent_mm_protocal_c_aun.wCx == null) {
            x.d("MicroMsg.NetSceneOpenBottle", "ERR: securityVerificationChecked errtype: rImpl.getBigContentInfo() == null");
            return k.b.hmQ;
        } else if (com_tencent_mm_protocal_c_aun.wCx.vYa == 0 && com_tencent_mm_protocal_c_aun.wCx.vIC == 0) {
            return k.b.hmP;
        } else {
            if (com_tencent_mm_protocal_c_aun.wCx.vYa <= com_tencent_mm_protocal_c_aun.wCx.vIC) {
                return k.b.hmQ;
            }
            return k.b.hmP;
        }
    }

    protected final int Bh() {
        return 10;
    }

    private int arC() {
        aun com_tencent_mm_protocal_c_aun = (aun) this.gJQ.hmg.hmo;
        auo com_tencent_mm_protocal_c_auo = (auo) this.gJQ.hmh.hmo;
        a aVar = new a();
        aVar.msgType = com_tencent_mm_protocal_c_aun.ngq;
        aVar.kAD = 0;
        aVar.kAF = 2;
        aVar.kAE = c.vN(com_tencent_mm_protocal_c_aun.wCw);
        aVar.kAH = bh.Wp();
        aVar.kAC = g.s(com_tencent_mm_protocal_c_aun.wCw.getBytes());
        if (this.msgType == 3) {
            aVar.content = this.fileName;
            aVar.kAG = com_tencent_mm_protocal_c_auo.vZy;
        } else {
            aVar.content = new String(com_tencent_mm_protocal_c_auo.wCA.vYb.wJD.oz);
        }
        i.arG().a(aVar);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            aun com_tencent_mm_protocal_c_aun = (aun) this.gJQ.hmg.hmo;
            auo com_tencent_mm_protocal_c_auo = (auo) this.gJQ.hmh.hmo;
            if (this.msgType == 1) {
                arC();
                cf auVar = new au();
                auVar.dS(com_tencent_mm_protocal_c_aun.wCw);
                auVar.setContent(n.b(com_tencent_mm_protocal_c_auo.wCA.vYb));
                auVar.aq(bh.Wp());
                auVar.eR(0);
                auVar.eQ(3);
                auVar.setType(c.ni(com_tencent_mm_protocal_c_aun.ngq));
                ar.Hg();
                c.Fa().Q(auVar);
                x.d("MicroMsg.NetSceneOpenBottle", "onGYNetEnd :" + auVar.field_content);
                this.gJT.a(i2, i3, str, this);
                return;
            }
            if (bh.ov(this.fileName)) {
                this.fileName = u.oe(this.kAK);
                this.kAM = new a(com.tencent.mm.modelvoice.q.getFullPath(this.fileName));
                this.kAL = 0;
            }
            if (com_tencent_mm_protocal_c_auo.wCA.vYa < com_tencent_mm_protocal_c_auo.wCA.vIC + com_tencent_mm_protocal_c_auo.wCA.vYb.wJB) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd tot:" + com_tencent_mm_protocal_c_auo.wCA.vYa + " start:" + com_tencent_mm_protocal_c_auo.wCA.vIC + " len:" + com_tencent_mm_protocal_c_auo.wCA.vYb.wJB);
                this.gJT.a(3, -1, str, this);
                return;
            } else if (com_tencent_mm_protocal_c_auo.wCA.vIC != this.kAL) {
                x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_auo.wCA.vIC + " off:" + this.kAL);
                this.gJT.a(3, -1, str, this);
                return;
            } else {
                int write = this.kAM.write(com_tencent_mm_protocal_c_auo.wCA.vYb.wJD.oz, com_tencent_mm_protocal_c_auo.wCA.vYb.wJB, com_tencent_mm_protocal_c_auo.wCA.vIC);
                if (write != com_tencent_mm_protocal_c_auo.wCA.vYb.wJB + com_tencent_mm_protocal_c_auo.wCA.vIC) {
                    x.e("MicroMsg.NetSceneOpenBottle", "onGYNetEnd start:" + com_tencent_mm_protocal_c_auo.wCA.vIC + " len:" + com_tencent_mm_protocal_c_auo.wCA.vYb.wJB + " writeRet:" + write);
                    this.gJT.a(3, -1, str, this);
                    return;
                }
                this.kAL = write;
                if (com_tencent_mm_protocal_c_auo.wCA.vYa <= this.kAL) {
                    arC();
                    au auVar2 = new au();
                    auVar2.dS(com_tencent_mm_protocal_c_aun.wCw);
                    auVar2.setContent(com.tencent.mm.modelvoice.n.b("bottle", (long) com_tencent_mm_protocal_c_auo.vZy, false));
                    auVar2.dT(this.fileName);
                    auVar2.aq(bh.Wp());
                    auVar2.eR(0);
                    auVar2.eQ(3);
                    auVar2.setType(c.ni(com_tencent_mm_protocal_c_aun.ngq));
                    ar.Hg();
                    c.Fa().Q(auVar2);
                    x.d("MicroMsg.NetSceneOpenBottle", "voice :" + com_tencent_mm_protocal_c_auo.vZy + " file:" + this.fileName);
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else if (a(this.hmA, this.gJT) == -1) {
                    this.gJT.a(3, -1, "doScene failed", this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.d("MicroMsg.NetSceneOpenBottle", "ERR: onGYNetEnd errtype:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 156;
    }
}
