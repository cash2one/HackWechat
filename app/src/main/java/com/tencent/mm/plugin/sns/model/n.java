package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class n extends k implements com.tencent.mm.network.k {
    private b gJQ;
    public e gJT;
    private String qTG;
    private bjf qTH;
    private int type;

    public n(bjf com_tencent_mm_protocal_c_bjf, String str) {
        a aVar = new a();
        aVar.hmj = new bjl();
        aVar.hmk = new bjm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.hmi = c.CTRL_INDEX;
        aVar.hml = 100;
        aVar.hmm = 1000000100;
        this.gJQ = aVar.JZ();
        bjl com_tencent_mm_protocal_c_bjl = (bjl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bjl.wMj = com_tencent_mm_protocal_c_bjf;
        this.type = com_tencent_mm_protocal_c_bjf.wMD.ktN;
        this.qTH = com_tencent_mm_protocal_c_bjf;
        com_tencent_mm_protocal_c_bjl.vGQ = str;
        this.qTG = str;
        x.d("MicroMsg.NetSceneSnsComment", com_tencent_mm_protocal_c_bjf.wMD.wFM + " " + com_tencent_mm_protocal_c_bjf.wMD.wbg);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        m eR = ae.bvv().eR(this.qTH.vPO);
        if (eR == null) {
            com.tencent.mm.plugin.sns.storage.e eK = ae.bvy().eK(this.qTH.vPO);
            if (eK != null) {
                eR = eK.bxX();
            }
        }
        if (eR != null) {
            try {
                bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(eR.field_attrBuf);
                if (com_tencent_mm_protocal_c_bjv.wNn != null && com_tencent_mm_protocal_c_bjv.wNn.wJE) {
                    bkd com_tencent_mm_protocal_c_bkd = (bkd) new bkd().aF(com_tencent_mm_protocal_c_bjv.wNn.wJD.oz);
                    bjl com_tencent_mm_protocal_c_bjl = (bjl) this.gJQ.hmg.hmo;
                    if (com_tencent_mm_protocal_c_bkd.wNC != null) {
                        x.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[]{String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bkd.wNC.vYT), Integer.valueOf(com_tencent_mm_protocal_c_bkd.wNC.vYU)})});
                        com_tencent_mm_protocal_c_bjl.wMk = new bdo().UA(r0);
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.bvu().c(this.qTH.vPO, this.type, this.qTG);
            bje com_tencent_mm_protocal_c_bje = this.qTH.wMD;
            if (com_tencent_mm_protocal_c_bje.ktN == 1 || com_tencent_mm_protocal_c_bje.ktN == 2 || com_tencent_mm_protocal_c_bje.ktN == 3 || com_tencent_mm_protocal_c_bje.ktN == 5) {
                bjk com_tencent_mm_protocal_c_bjk = new bjk();
                com_tencent_mm_protocal_c_bjk.pbl = com_tencent_mm_protocal_c_bje.pbl;
                com_tencent_mm_protocal_c_bjk.ktN = com_tencent_mm_protocal_c_bje.ktN;
                com_tencent_mm_protocal_c_bjk.vHW = com_tencent_mm_protocal_c_bje.vHW;
                com_tencent_mm_protocal_c_bjk.vIy = com_tencent_mm_protocal_c_bje.wFM;
                com_tencent_mm_protocal_c_bjk.wvW = com_tencent_mm_protocal_c_bje.wMt;
                com_tencent_mm_protocal_c_bjk.nje = com_tencent_mm_protocal_c_bje.nje;
                com_tencent_mm_protocal_c_bjk.wMB = com_tencent_mm_protocal_c_bje.wMB;
                try {
                    bjv com_tencent_mm_protocal_c_bjv = ((bjm) this.gJQ.hmh.hmo).wMm;
                    if (com_tencent_mm_protocal_c_bje.ktN == 1 || com_tencent_mm_protocal_c_bje.ktN == 5) {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_bjv.vPO + " " + com.tencent.mm.platformtools.n.b(com_tencent_mm_protocal_c_bjv.wMW) + " " + com_tencent_mm_protocal_c_bjv.wNa.size() + " " + com_tencent_mm_protocal_c_bjv.wNd.size());
                    } else {
                        x.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_bjv.vPO + " " + com_tencent_mm_protocal_c_bjv.wNa.size() + " " + com_tencent_mm_protocal_c_bjv.wNd.size());
                    }
                    ai.d(com_tencent_mm_protocal_c_bjv);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            ae.bvu().buW();
        } else if (i2 == 4) {
            ae.bvu().c(this.qTH.vPO, this.type, this.qTG);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
