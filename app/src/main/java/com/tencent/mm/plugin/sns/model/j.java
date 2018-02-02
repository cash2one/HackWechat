package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    private String qTG;
    private bjf qTH;
    private int type;

    public j(bjf com_tencent_mm_protocal_c_bjf, String str, String str2) {
        blu mN;
        a aVar = new a();
        aVar.hmj = new biw();
        aVar.hmk = new bix();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        aVar.hmi = 682;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        biw com_tencent_mm_protocal_c_biw = (biw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_biw.wMj = com_tencent_mm_protocal_c_bjf;
        this.type = com_tencent_mm_protocal_c_bjf.wMD.ktN;
        this.qTH = com_tencent_mm_protocal_c_bjf;
        com_tencent_mm_protocal_c_biw.vGQ = str;
        this.qTG = str;
        com.tencent.mm.plugin.sns.storage.e eK = ae.bvy().eK(com_tencent_mm_protocal_c_bjf.vPO);
        if (eK != null) {
            bnp bxV = eK.bxV();
            if (bxV != null) {
                mN = p.mN(bxV.rtA);
            } else {
                x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
                mN = null;
            }
        } else {
            x.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
            mN = null;
        }
        if (mN != null) {
            com_tencent_mm_protocal_c_biw.wMk = n.os(p.a(mN));
            com_tencent_mm_protocal_c_biw.vHW = mN.cOY;
        }
        com_tencent_mm_protocal_c_biw.wMi = n.os(bh.az(str2, ""));
        x.i("MicroMsg.NetSceneSnsAdComment", com_tencent_mm_protocal_c_bjf.wMD.wFM + " " + com_tencent_mm_protocal_c_bjf.wMD.wbg + " type " + com_tencent_mm_protocal_c_bjf.wMD.ktN + " aduxinfo " + str2 + ", SnsStat=" + com_tencent_mm_protocal_c_biw.wMk + ", source=" + com_tencent_mm_protocal_c_biw.vHW);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.bvu().c(this.qTH.vPO, this.type, this.qTG);
            bje com_tencent_mm_protocal_c_bje = this.qTH.wMD;
            if (com_tencent_mm_protocal_c_bje.ktN == 1 || com_tencent_mm_protocal_c_bje.ktN == 2 || com_tencent_mm_protocal_c_bje.ktN == 3 || com_tencent_mm_protocal_c_bje.ktN == 5 || com_tencent_mm_protocal_c_bje.ktN == 7 || com_tencent_mm_protocal_c_bje.ktN == 8) {
                bjk com_tencent_mm_protocal_c_bjk = new bjk();
                com_tencent_mm_protocal_c_bjk.pbl = com_tencent_mm_protocal_c_bje.pbl;
                com_tencent_mm_protocal_c_bjk.ktN = com_tencent_mm_protocal_c_bje.ktN;
                com_tencent_mm_protocal_c_bjk.vHW = com_tencent_mm_protocal_c_bje.vHW;
                com_tencent_mm_protocal_c_bjk.vIy = com_tencent_mm_protocal_c_bje.wFM;
                com_tencent_mm_protocal_c_bjk.wvW = com_tencent_mm_protocal_c_bje.wMt;
                com_tencent_mm_protocal_c_bjk.nje = com_tencent_mm_protocal_c_bje.nje;
                com_tencent_mm_protocal_c_bjk.wMB = com_tencent_mm_protocal_c_bje.wMB;
                try {
                    bjv com_tencent_mm_protocal_c_bjv;
                    biw com_tencent_mm_protocal_c_biw = (biw) this.gJQ.hmg.hmo;
                    bix com_tencent_mm_protocal_c_bix = (bix) this.gJQ.hmh.hmo;
                    if (com_tencent_mm_protocal_c_biw.vHW == 1 || com_tencent_mm_protocal_c_biw.vHW == 2) {
                        bkj com_tencent_mm_protocal_c_bkj = com_tencent_mm_protocal_c_bix.wHL;
                        com_tencent_mm_protocal_c_bjv = com_tencent_mm_protocal_c_bkj.wMm;
                        a.a(com_tencent_mm_protocal_c_bkj);
                    } else {
                        biz com_tencent_mm_protocal_c_biz = com_tencent_mm_protocal_c_bix.vHo;
                        com_tencent_mm_protocal_c_bjv = com_tencent_mm_protocal_c_biz.wMm;
                        a.a(com_tencent_mm_protocal_c_biz);
                    }
                    x.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + com_tencent_mm_protocal_c_bjv.toString() + " " + com_tencent_mm_protocal_c_bjv.wNa.size() + " " + com_tencent_mm_protocal_c_bjv.wNd.size());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            ae.bvu().buW();
        } else if (i2 == 4) {
            ae.bvu().c(this.qTH.vPO, this.type, this.qTG);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
