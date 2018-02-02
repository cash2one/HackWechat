package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkw;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements com.tencent.mm.network.k {
    public int Pb = 0;
    final int fqd;
    private b gJQ;
    public e gJT;
    private long qTM = 0;
    public int qTO = 0;
    public int qTP = 0;
    private long qUl = 0;
    private String qUm = "";

    public s() {
        int i;
        a aVar = new a();
        aVar.hmj = new bkw();
        aVar.hmk = new bkx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.hmi = 718;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        if (an.isWifi(ac.getContext())) {
            i = 1;
        } else if (an.is3G(ac.getContext())) {
            i = 3;
        } else if (an.is4G(ac.getContext())) {
            i = 4;
        } else if (an.is2G(ac.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.fqd = 2;
        bkw com_tencent_mm_protocal_c_bkw = (bkw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bkw.wOj = i;
        com_tencent_mm_protocal_c_bkw.wMK = 0;
        int bvU = ae.bvl().bvU();
        this.qTM = ae.bvv().d(0, bvU, true);
        com_tencent_mm_protocal_c_bkw.wOg = this.qTM;
        com_tencent_mm_protocal_c_bkw.wOh = c.a(this.qTM, 0, "@__weixintimtline");
        this.qUl = ae.bvv().d(0, 1, true);
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.qUl);
        com_tencent_mm_protocal_c_bkw.wOi = this.qUl;
        com.tencent.mm.plugin.sns.storage.k Lq = ae.bvz().Lq("@__weixintimtline");
        this.qUm = Lq == null ? "" : Lq.field_md5;
        if (this.qUm == null) {
            this.qUm = "";
        }
        com_tencent_mm_protocal_c_bkw.wMJ = this.qUm;
        if (Lq == null || Lq.field_adsession == null) {
            com_tencent_mm_protocal_c_bkw.wMo = new bdn().bj(new byte[0]);
        } else {
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", Lq.field_adsession);
            com_tencent_mm_protocal_c_bkw.wMo = new bdn().bj(Lq.field_adsession);
        }
        x.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + bvU + " min:" + this.qTM + " ReqTime:" + com_tencent_mm_protocal_c_bkw.wOh + " nettype: " + i);
        x.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", i.eq(this.qTM), Integer.valueOf(r7));
    }

    private void a(bkx com_tencent_mm_protocal_c_bkx, String str) {
        ai.a("@__weixintimtline", this.fqd, com_tencent_mm_protocal_c_bkx.vLo, str);
        this.qTM = ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO;
        c.d("@__weixintimtline", ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO, this.qTM, com_tencent_mm_protocal_c_bkx.wOk);
        Iterator it = com_tencent_mm_protocal_c_bkx.vLo.iterator();
        while (it.hasNext()) {
            bjv com_tencent_mm_protocal_c_bjv = (bjv) it.next();
            if (com_tencent_mm_protocal_c_bjv.wNh == 0) {
                m eR = ae.bvv().eR(com_tencent_mm_protocal_c_bjv.vPO);
                if (!(eR == null || eR.bxV() == null)) {
                    List<aqr> list = eR.bxV().wQo.vYd;
                    for (aqr com_tencent_mm_protocal_c_aqr : list) {
                        Object obj = list.size() <= 1 ? 1 : null;
                        if (com_tencent_mm_protocal_c_aqr != null) {
                            String e = i.e(com_tencent_mm_protocal_c_aqr);
                            int i = obj != null ? 1 : 0;
                            String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                            if (FileOp.bO(r + e) || FileOp.bO(r + i.l(com_tencent_mm_protocal_c_aqr)) || FileOp.bO(r + i.m(com_tencent_mm_protocal_c_aqr))) {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", com_tencent_mm_protocal_c_aqr.nGJ);
                            } else {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", com_tencent_mm_protocal_c_aqr.nGJ);
                                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_aqr);
                                eVar.qQR = i;
                                eVar.hKZ = com_tencent_mm_protocal_c_aqr.nGJ;
                                ae.bvq().a(com_tencent_mm_protocal_c_aqr, com_tencent_mm_protocal_c_aqr.ktN == 6 ? 5 : 1, eVar, com.tencent.mm.storage.an.xyQ);
                            }
                        }
                    }
                    if (eR.field_type == 15) {
                        aq bvt = ae.bvt();
                        if (eR != null) {
                            x.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", Integer.valueOf(bvt.hashCode()), eR.byq());
                            synchronized (bvt.qXF) {
                                bvt.qXF.addFirst(eR);
                            }
                        }
                        try {
                            String str2 = ((aqr) eR.bxV().wQo.vYd.get(0)).nfX;
                            g.pQN.h(14388, Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e2) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        ae.bvt().bvZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkx com_tencent_mm_protocal_c_bkx = (bkx) ((b) qVar).hmh.hmo;
        if (qVar.Hp().vBp == 207 || qVar.Hp().vBp == 0) {
            if (com_tencent_mm_protocal_c_bkx.wMP != null) {
                x.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + com_tencent_mm_protocal_c_bkx.wMP.wOc + " " + com_tencent_mm_protocal_c_bkx.wMP.wOb);
                int i4 = com_tencent_mm_protocal_c_bkx.wMP.wOc;
                com.tencent.mm.plugin.sns.c.a.qQF = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qQF = Integer.MAX_VALUE;
                }
                v.xmH = com_tencent_mm_protocal_c_bkx.wMP.wOb;
            }
            this.qTO = com_tencent_mm_protocal_c_bkx.wMN;
            this.qTP = com_tencent_mm_protocal_c_bkx.wMO;
            x.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + com_tencent_mm_protocal_c_bkx.wMN + " , objCount:  " + com_tencent_mm_protocal_c_bkx.wzD + " cflag : " + com_tencent_mm_protocal_c_bkx.wMO);
            this.Pb = com_tencent_mm_protocal_c_bkx.wzD;
            String er = i.er(0);
            if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + com_tencent_mm_protocal_c_bkx.vLo.size() + " Max " + ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO + " " + i.eq(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO) + "  respone min  " + ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO + " " + i.eq(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO));
            }
            this.Pb = com_tencent_mm_protocal_c_bkx.wzD;
            if (this.qUm.equals(com_tencent_mm_protocal_c_bkx.wMJ)) {
                this.qTM = ae.bvv().d(0, this.qTO, true);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qTM));
                x.Kd("@__weixintimtline");
                this.gJT.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + com_tencent_mm_protocal_c_bkx.vLo.size() + " adsize : " + com_tencent_mm_protocal_c_bkx.wOl);
            ae.bvz().e("@__weixintimtline", com_tencent_mm_protocal_c_bkx.wMJ, n.a(com_tencent_mm_protocal_c_bkx.wMo));
            for (int i5 = 0; i5 < com_tencent_mm_protocal_c_bkx.wOm.size(); i5++) {
                cc ccVar = (cc) com_tencent_mm_protocal_c_bkx.wOm.get(i5);
                String a = n.a(ccVar.vHp);
                String a2 = n.a(ccVar.vHo.wMn);
                String b = n.b(ccVar.vHo.wMm.wMW);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + a);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + a2);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + "\r\n");
            }
            a.e(com_tencent_mm_protocal_c_bkx.wOm, com_tencent_mm_protocal_c_bkx.vLo);
            a.af(com_tencent_mm_protocal_c_bkx.wOm);
            if (com_tencent_mm_protocal_c_bkx.wOl == 0) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", Integer.valueOf(com_tencent_mm_protocal_c_bkx.wOn));
                a.d(com_tencent_mm_protocal_c_bkx.wOo, com_tencent_mm_protocal_c_bkx.vLo);
                a.ae(com_tencent_mm_protocal_c_bkx.wOo);
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = com_tencent_mm_protocal_c_bkx.vLo.iterator();
            while (it.hasNext()) {
                linkedList.add(Long.valueOf(((bjv) it.next()).vPO));
            }
            com.tencent.mm.sdk.b.b qhVar = new qh();
            qhVar.fHS.fHT = linkedList;
            com.tencent.mm.sdk.b.a.xef.m(qhVar);
            if (qVar.Hp().vBp == 207) {
                if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                    ae.bvv().byH();
                } else {
                    ae.bvv().Ls(i.er(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO));
                    ae.bvv().Lr(i.er(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO));
                    a(com_tencent_mm_protocal_c_bkx, er);
                    a.ag(com_tencent_mm_protocal_c_bkx.vLo);
                }
                x.Kd("@__weixintimtline");
                this.gJT.a(i2, i3, str, this);
                return;
            }
            if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                ae.bvv().byH();
            } else {
                a(com_tencent_mm_protocal_c_bkx, er);
                a.ag(com_tencent_mm_protocal_c_bkx.vLo);
            }
            x.Kd("@__weixintimtline");
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.Kd("@__weixintimtline");
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 718;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
