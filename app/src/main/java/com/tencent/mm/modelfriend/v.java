package com.tencent.mm.modelfriend;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.adq;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v extends k implements com.tencent.mm.network.k {
    b gJQ;
    private e gJT = null;
    private List<String> hvQ;
    private List<String> hwx;

    public v() {
        Om();
        adp com_tencent_mm_protocal_c_adp = (adp) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_adp.vZU = "";
        com_tencent_mm_protocal_c_adp.wmi = null;
        com_tencent_mm_protocal_c_adp.wmh = 0;
        com_tencent_mm_protocal_c_adp.wmg = null;
        com_tencent_mm_protocal_c_adp.wmf = 0;
        com_tencent_mm_protocal_c_adp.nhx = 0;
        com_tencent_mm_protocal_c_adp.rYW = 1;
    }

    public v(List<String> list, List<String> list2) {
        Om();
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            this.hvQ = list;
            this.hwx = list2;
            adp com_tencent_mm_protocal_c_adp = (adp) this.gJQ.hmg.hmo;
            com_tencent_mm_protocal_c_adp.vZU = "";
            com_tencent_mm_protocal_c_adp.nhx = 2;
            com_tencent_mm_protocal_c_adp.rYW = 1;
        }
    }

    private void Om() {
        a aVar = new a();
        aVar.hmj = new adp();
        aVar.hmk = new adq();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.hmi = 142;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final void On() {
        adp com_tencent_mm_protocal_c_adp = (adp) this.gJQ.hmg.hmo;
        ar.Hg();
        com_tencent_mm_protocal_c_adp.vZU = (String) c.CU().get(65828, null);
        com_tencent_mm_protocal_c_adp.nhx = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        adp com_tencent_mm_protocal_c_adp = (adp) this.gJQ.hmg.hmo;
        if (com_tencent_mm_protocal_c_adp.nhx == 2) {
            if ((this.hvQ == null || this.hvQ.size() == 0) && (this.hwx == null || this.hwx.size() == 0)) {
                x.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                return -1;
            }
            LinkedList linkedList;
            if (this.hvQ != null && this.hvQ.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[]{Integer.valueOf(this.hvQ.size())});
                linkedList = new LinkedList();
                for (String str : this.hvQ) {
                    arf com_tencent_mm_protocal_c_arf = new arf();
                    com_tencent_mm_protocal_c_arf.v = str;
                    linkedList.add(com_tencent_mm_protocal_c_arf);
                }
                com_tencent_mm_protocal_c_adp.wmg = linkedList;
                com_tencent_mm_protocal_c_adp.wmf = linkedList.size();
            }
            if (this.hwx != null && this.hwx.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[]{Integer.valueOf(this.hwx.size())});
                linkedList = new LinkedList();
                for (String str2 : this.hwx) {
                    apf com_tencent_mm_protocal_c_apf = new apf();
                    com_tencent_mm_protocal_c_apf.v = str2;
                    linkedList.add(com_tencent_mm_protocal_c_apf);
                }
                com_tencent_mm_protocal_c_adp.wmi = linkedList;
                com_tencent_mm_protocal_c_adp.wmh = linkedList.size();
            }
        }
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        adq com_tencent_mm_protocal_c_adq = (adq) this.gJQ.hmh.hmo;
        adp com_tencent_mm_protocal_c_adp = (adp) this.gJQ.hmg.hmo;
        if (i2 == 4 && i3 == -68) {
            this.gJT.a(i2, i3, com_tencent_mm_protocal_c_adq.wJr.vLc.wJF, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            ar.Hg();
            String ou = bh.ou((String) c.CU().get(65828, null));
            if (!(com_tencent_mm_protocal_c_adp.nhx != 1 || bh.ov(com_tencent_mm_protocal_c_adq.vZU) || com_tencent_mm_protocal_c_adq.vZU.equals(ou))) {
                ar.Hg();
                c.CU().set(65828, com_tencent_mm_protocal_c_adq.vZU);
                af.OE().NG();
            }
            if (com_tencent_mm_protocal_c_adq.nfM == null) {
                x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                return;
            }
            x.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adq.nfM.size())});
            ar.Hg();
            long dz = c.EV().dz(Thread.currentThread().getId());
            for (int i4 = 0; i4 < com_tencent_mm_protocal_c_adq.nfM.size(); i4++) {
                apg com_tencent_mm_protocal_c_apg = (apg) com_tencent_mm_protocal_c_adq.nfM.get(i4);
                if (com_tencent_mm_protocal_c_apg == null) {
                    x.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                } else {
                    b kS = af.OD().kS(com_tencent_mm_protocal_c_apg.hvs);
                    if (kS != null || com_tencent_mm_protocal_c_adp.nhx == 1) {
                        ar.Hg();
                        c.FI().fB(com_tencent_mm_protocal_c_apg.vIy, com_tencent_mm_protocal_c_apg.whR);
                        h hVar = new h();
                        if (com_tencent_mm_protocal_c_adp.nhx == 1) {
                            if (com_tencent_mm_protocal_c_apg.wvX == null) {
                                x.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                            } else {
                                hVar.fWh = com_tencent_mm_protocal_c_apg.wvX.pRd;
                                hVar.hvN = com_tencent_mm_protocal_c_apg.wvX.wbS;
                                com.tencent.mm.ad.b.iQ(com_tencent_mm_protocal_c_apg.wvX.pRd);
                                hVar.hvM = com_tencent_mm_protocal_c_apg.wvX.nfp;
                                hVar.gfN = com_tencent_mm_protocal_c_apg.hvy;
                                hVar.fWq = com_tencent_mm_protocal_c_apg.hvv;
                                hVar.fWp = com_tencent_mm_protocal_c_apg.hvu;
                                hVar.signature = com_tencent_mm_protocal_c_apg.hvw;
                                hVar.fWo = com_tencent_mm_protocal_c_apg.hvx;
                                hVar.fWf = com_tencent_mm_protocal_c_apg.hvt;
                                hVar.bgo = com_tencent_mm_protocal_c_apg.wvW;
                                hVar.hvm = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_apg.wvX.nfp);
                                hVar.hvn = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_apg.wvX.nfp);
                                hVar.username = com_tencent_mm_protocal_c_apg.vIy;
                            }
                        } else if (bh.ov(com_tencent_mm_protocal_c_apg.vIy)) {
                            x.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                        }
                        k kVar = new k();
                        kVar.username = com_tencent_mm_protocal_c_apg.vIy;
                        kVar.fWp = com_tencent_mm_protocal_c_apg.hvu;
                        kVar.fWq = com_tencent_mm_protocal_c_apg.hvv;
                        kVar.signature = com_tencent_mm_protocal_c_apg.hvw;
                        kVar.fWf = com_tencent_mm_protocal_c_apg.hvt;
                        kVar.fWo = com_tencent_mm_protocal_c_apg.hvx;
                        af afVar = null;
                        if (!bh.ov(com_tencent_mm_protocal_c_apg.vIy)) {
                            ar.Hg();
                            afVar = c.EY().WO(com_tencent_mm_protocal_c_apg.vIy);
                            if (afVar == null || !com_tencent_mm_protocal_c_apg.vIy.equals(afVar.field_username)) {
                                afVar = null;
                            } else if (!(bh.ov(com_tencent_mm_protocal_c_apg.hvy) || com_tencent_mm_protocal_c_apg.hvy.equals(afVar.vN()))) {
                                afVar.cZ(com_tencent_mm_protocal_c_apg.hvy);
                                ar.Hg();
                                c.EY().a(afVar.field_username, afVar);
                            }
                        }
                        if (bh.ov(com_tencent_mm_protocal_c_apg.vIy)) {
                            Assert.assertTrue("mobile friend never go here", com_tencent_mm_protocal_c_adp.nhx == 1);
                            hVar.status = 102;
                        } else if (afVar == null || !com.tencent.mm.l.a.fZ(afVar.field_type)) {
                            hVar.status = 100;
                            if (kS != null) {
                                x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + com_tencent_mm_protocal_c_apg.wvW + " realName:" + kS.Nt() + "  MFriend:" + com_tencent_mm_protocal_c_apg.toString());
                                kS.status = 1;
                                kS.username = com_tencent_mm_protocal_c_apg.vIy;
                                kS.bgo = com_tencent_mm_protocal_c_apg.wvW;
                                kS.hvm = com.tencent.mm.platformtools.c.om(com_tencent_mm_protocal_c_apg.wvX.nfp);
                                kS.hvn = com.tencent.mm.platformtools.c.ol(com_tencent_mm_protocal_c_apg.wvX.nfp);
                                kS.hvr = kS.Ad();
                                a(kS, com_tencent_mm_protocal_c_apg);
                                kS.fDt = -1;
                                af.OD().a(kS.Nr(), kS);
                                h hVar2 = new h();
                                hVar2.username = com_tencent_mm_protocal_c_apg.vIy;
                                hVar2.hly = com_tencent_mm_protocal_c_apg.vUU;
                                hVar2.hlx = com_tencent_mm_protocal_c_apg.vUV;
                                hVar2.bA(true);
                                hVar2.fWe = 3;
                                n.JQ().a(hVar2);
                            }
                        } else {
                            hVar.status = 101;
                            if (kS != null) {
                                x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + com_tencent_mm_protocal_c_apg.wvW + "  md5:" + com_tencent_mm_protocal_c_apg.hvs);
                                kS.status = 2;
                                kS.username = com_tencent_mm_protocal_c_apg.vIy;
                                kS.bgo = com_tencent_mm_protocal_c_apg.wvW;
                                kS.hvr = kS.Ad();
                                a(kS, com_tencent_mm_protocal_c_apg);
                                kS.fDt = -1;
                                af.OD().a(kS.Nr(), kS);
                                com.tencent.mm.ad.b.I(com_tencent_mm_protocal_c_apg.vIy, 3);
                            }
                        }
                        if (com_tencent_mm_protocal_c_adp.nhx == 1) {
                            af.OE().a(hVar);
                        }
                        af.OF().a(kVar);
                    } else {
                        x.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + com_tencent_mm_protocal_c_apg.wvW + " md5: " + com_tencent_mm_protocal_c_apg.hvs);
                    }
                }
            }
            ar.Hg();
            c.EV().fS(dz);
            this.gJT.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gJT.a(i2, i3, str, this);
        }
    }

    private static void a(b bVar, apg com_tencent_mm_protocal_c_apg) {
        bVar.hvs = com_tencent_mm_protocal_c_apg.hvs;
        bVar.hvt = com_tencent_mm_protocal_c_apg.hvt;
        bVar.hvu = com_tencent_mm_protocal_c_apg.hvu;
        bVar.hvv = com_tencent_mm_protocal_c_apg.hvv;
        bVar.hvw = com_tencent_mm_protocal_c_apg.hvw;
        bVar.hvx = com_tencent_mm_protocal_c_apg.hvx;
        bVar.hvy = com_tencent_mm_protocal_c_apg.hvy;
        bVar.hvz = com_tencent_mm_protocal_c_apg.hvz;
        bVar.hvB = com_tencent_mm_protocal_c_apg.hvB;
        bVar.hvA = com_tencent_mm_protocal_c_apg.hvA;
        bVar.hvC = com_tencent_mm_protocal_c_apg.hvC;
        bVar.hvD = com_tencent_mm_protocal_c_apg.hvD;
        bla com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_apg.wvl;
        if (com_tencent_mm_protocal_c_bla != null) {
            bVar.hvE = com_tencent_mm_protocal_c_bla.hvE;
            bVar.hvF = com_tencent_mm_protocal_c_bla.hvF;
            bVar.hvG = com_tencent_mm_protocal_c_bla.hvG;
        }
        pq pqVar = com_tencent_mm_protocal_c_apg.wvm;
        if (pqVar != null) {
            bVar.hvH = pqVar.hvH;
            bVar.hvI = pqVar.hvI;
            bVar.hvJ = pqVar.hvJ;
            bVar.hvK = pqVar.hvK;
        }
    }
}
