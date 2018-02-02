package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkw;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.cc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.storage.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x extends k implements com.tencent.mm.network.k, d {
    private static Vector<String> qTN = new Vector();
    public int Pb = 0;
    final int fqd;
    private b gJQ;
    public e gJT;
    private boolean hLV = false;
    public boolean qTK;
    private long qTL = 0;
    long qTM = 0;
    public int qTO = 0;
    public int qTP = 0;
    private long qUD = 0;
    private boolean qUE = false;
    private boolean qUF = false;
    private long qUl = 0;
    private String qUm = "";

    public static synchronized boolean Kc(String str) {
        boolean z;
        synchronized (x.class) {
            if (qTN.contains(str)) {
                z = false;
            } else {
                qTN.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Kd(String str) {
        synchronized (x.class) {
            qTN.remove(str);
        }
        return true;
    }

    public x(long j) {
        int i;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.hmj = new bkw();
        aVar.hmk = new bkx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.hmi = h.CTRL_INDEX;
        aVar.hml = 98;
        aVar.hmm = 1000000098;
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
        this.qTL = j;
        this.qTK = j == 0;
        this.fqd = 2;
        bkw com_tencent_mm_protocal_c_bkw = (bkw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bkw.wOj = i;
        com_tencent_mm_protocal_c_bkw.wMK = j;
        int bvU = ae.bvl().bvU();
        n bvv = ae.bvv();
        if (this.qTK) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.qTM = bvv.d(j2, bvU, true);
        com_tencent_mm_protocal_c_bkw.wOg = this.qTM;
        com_tencent_mm_protocal_c_bkw.wOh = c.a(this.qTM, j, "@__weixintimtline");
        if (this.qTK) {
            this.qUl = ae.bvv().d(0, 1, true);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.qUl);
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
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", Lq.field_adsession);
                com_tencent_mm_protocal_c_bkw.wMo = new bdn().bj(Lq.field_adsession);
            }
        }
        this.qUD = j;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + bvU + " max:" + j + " min:" + this.qTM + " ReqTime:" + com_tencent_mm_protocal_c_bkw.wOh + " nettype: " + i);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", i.eq(j), i.eq(this.qTM), Integer.valueOf(r3));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void buS() {
        n bvv = ae.bvv();
        Cursor a = bvv.gJP.a(n.xn(3), null, 2);
        int i = 0;
        while (a.moveToNext()) {
            i++;
        }
        a.close();
        if (i < 3 && i > 0) {
            this.qUF = true;
        } else if (i == 0) {
            this.qUE = true;
        }
    }

    private void a(bkx com_tencent_mm_protocal_c_bkx, String str) {
        ai.a("@__weixintimtline", this.fqd, com_tencent_mm_protocal_c_bkx.vLo, str);
        this.qTM = ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO;
        if (this.qTL == 0) {
            this.qTL = ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO;
        } else {
            this.qTL = c.eu(this.qTL);
        }
        c.d("@__weixintimtline", this.qTL, this.qTM, com_tencent_mm_protocal_c_bkx.wOk);
        try {
            Iterator it = com_tencent_mm_protocal_c_bkx.vLo.iterator();
            while (it.hasNext()) {
                bjv com_tencent_mm_protocal_c_bjv = (bjv) it.next();
                if (com_tencent_mm_protocal_c_bjv.wNh == 0) {
                    m eR = ae.bvv().eR(com_tencent_mm_protocal_c_bjv.vPO);
                    if (!(eR == null || eR.bxV() == null || eR.field_type != 15)) {
                        try {
                            String str2 = ((aqr) eR.bxV().wQo.vYd.get(0)).nfX;
                            g.pQN.h(14388, Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bkx com_tencent_mm_protocal_c_bkx = (bkx) ((b) qVar).hmh.hmo;
        if (qVar.Hp().vBp == 207 || qVar.Hp().vBp == 0) {
            if (com_tencent_mm_protocal_c_bkx.wMP != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + com_tencent_mm_protocal_c_bkx.wMP.wOc + " " + com_tencent_mm_protocal_c_bkx.wMP.wOb);
                int i4 = com_tencent_mm_protocal_c_bkx.wMP.wOc;
                com.tencent.mm.plugin.sns.c.a.qQF = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qQF = Integer.MAX_VALUE;
                }
                v.xmH = com_tencent_mm_protocal_c_bkx.wMP.wOb;
            }
            this.qTO = com_tencent_mm_protocal_c_bkx.wMN;
            this.qTP = com_tencent_mm_protocal_c_bkx.wMO;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + com_tencent_mm_protocal_c_bkx.wMN + " , objCount:  " + com_tencent_mm_protocal_c_bkx.wzD + " cflag : " + com_tencent_mm_protocal_c_bkx.wMO);
            this.Pb = com_tencent_mm_protocal_c_bkx.wzD;
            String er = i.er(this.qTL);
            if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + com_tencent_mm_protocal_c_bkx.vLo.size() + " Max " + ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO + " " + i.eq(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO) + "  respone min  " + ((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO + " " + i.eq(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO));
            }
            if (this.qTK) {
                this.Pb = com_tencent_mm_protocal_c_bkx.wzD;
                if (this.qUm.equals(com_tencent_mm_protocal_c_bkx.wMJ)) {
                    this.qTM = ae.bvv().d(this.qTK ? 0 : this.qUD, this.qTO, true);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qTM));
                    buS();
                    Kd("@__weixintimtline");
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
                cc ccVar;
                String str2;
                String a;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + com_tencent_mm_protocal_c_bkx.vLo.size() + " adsize : " + com_tencent_mm_protocal_c_bkx.wOl);
                ae.bvz().e("@__weixintimtline", com_tencent_mm_protocal_c_bkx.wMJ, com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_bkx.wMo));
                for (int i5 = 0; i5 < com_tencent_mm_protocal_c_bkx.wOm.size(); i5++) {
                    ccVar = (cc) com_tencent_mm_protocal_c_bkx.wOm.get(i5);
                    if (this.hLV) {
                        str2 = ae.FC() + "ad.proto";
                        try {
                            byte[] toByteArray = ccVar.toByteArray();
                            com.tencent.mm.a.e.b(str2, toByteArray, toByteArray.length);
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                        }
                    }
                    str2 = com.tencent.mm.platformtools.n.a(ccVar.vHp);
                    a = com.tencent.mm.platformtools.n.a(ccVar.vHo.wMn);
                    String b = com.tencent.mm.platformtools.n.b(ccVar.vHo.wMm.wMW);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + a);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + "\r\n");
                }
                if (this.hLV && com_tencent_mm_protocal_c_bkx.wOm.size() == 0) {
                    try {
                        byte[] e2 = com.tencent.mm.a.e.e(ae.FC() + "ad.proto", 0, -1);
                        cc ccVar2 = new cc();
                        ccVar2.aF(e2);
                        com_tencent_mm_protocal_c_bkx.wOm.add(ccVar2);
                        com_tencent_mm_protocal_c_bkx.wOl = com_tencent_mm_protocal_c_bkx.wOm.size();
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + com_tencent_mm_protocal_c_bkx.wOl);
                        if (com_tencent_mm_protocal_c_bkx.wOm.size() > 0) {
                            ccVar = (cc) com_tencent_mm_protocal_c_bkx.wOm.get(0);
                            String a2 = com.tencent.mm.platformtools.n.a(ccVar.vHp);
                            str2 = com.tencent.mm.platformtools.n.a(ccVar.vHo.wMn);
                            a = com.tencent.mm.platformtools.n.b(ccVar.vHo.wMm.wMW);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + a2);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + str2);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + "\r\n");
                            b(ccVar);
                        }
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e3.getMessage());
                    }
                }
                a.e(com_tencent_mm_protocal_c_bkx.wOm, com_tencent_mm_protocal_c_bkx.vLo);
                a.af(com_tencent_mm_protocal_c_bkx.wOm);
                if (com_tencent_mm_protocal_c_bkx.wOl == 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", Integer.valueOf(com_tencent_mm_protocal_c_bkx.wOn));
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
                        this.qTM = this.qTL;
                    } else {
                        ae.bvv().Ls(i.er(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getFirst()).vPO));
                        ae.bvv().Lr(i.er(((bjv) com_tencent_mm_protocal_c_bkx.vLo.getLast()).vPO));
                        a(com_tencent_mm_protocal_c_bkx, er);
                        a.ag(com_tencent_mm_protocal_c_bkx.vLo);
                    }
                    this.qUE = true;
                    Kd("@__weixintimtline");
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
                if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                    ae.bvv().byH();
                    this.qTM = this.qTL;
                    this.qUE = true;
                } else {
                    a(com_tencent_mm_protocal_c_bkx, er);
                    a.ag(com_tencent_mm_protocal_c_bkx.vLo);
                }
                Kd("@__weixintimtline");
                this.gJT.a(i2, i3, str, this);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + com_tencent_mm_protocal_c_bkx.vLo.size());
            if (com_tencent_mm_protocal_c_bkx.vLo.isEmpty()) {
                ae.bvv().Lr(er);
                this.qUE = true;
                this.qTM = this.qTL;
            } else {
                a(com_tencent_mm_protocal_c_bkx, er);
            }
            Kd("@__weixintimtline");
            this.gJT.a(i2, i3, str, this);
            return;
        }
        Kd("@__weixintimtline");
        this.gJT.a(i2, i3, str, this);
    }

    private static boolean b(cc ccVar) {
        if (!an.isWifi(ac.getContext())) {
            return false;
        }
        try {
            com.tencent.mm.modelsns.e.mG(com.tencent.mm.platformtools.n.b(ccVar.vHo.wMm.wMW));
            ae.bvq();
            b.buz();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final int getType() {
        return h.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean buB() {
        return this.qTK;
    }

    public final boolean buC() {
        return this.qUE;
    }

    public final boolean buD() {
        return this.qUF;
    }

    public final boolean buE() {
        return false;
    }

    public final long buF() {
        return this.qTM;
    }

    public final boolean buG() {
        return false;
    }

    public final long buH() {
        return 0;
    }
}
