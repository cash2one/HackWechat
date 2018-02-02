package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.y;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.c.gb;
import com.tencent.mm.protocal.c.gc;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.pq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gOB = null;
    private b lMW = null;
    private String[] lMX;

    public k(String[] strArr, String str) {
        this.lMX = strArr;
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[]{str, Integer.valueOf(1)});
        a aVar = new a();
        aVar.hmj = new gb();
        aVar.hmk = new gc();
        aVar.hmi = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.lMW = aVar.JZ();
        gb gbVar = (gb) this.lMW.hmg.hmo;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                ga gaVar = new ga();
                gaVar.vLs = str2;
                linkedList.add(gaVar);
                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[]{str2});
            }
        }
        gbVar.vLt = linkedList;
        if (!bh.ov(str)) {
            fz fzVar = new fz();
            fzVar.vLr = str;
            gbVar.vLu = fzVar;
        }
        gbVar.vLv = 3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.lMX != null && this.lMX.length == 1) {
            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[]{this.lMX[0]});
        }
        if (qVar == null) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
        } else if (this.lMW.hmi != qVar.getType()) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[]{Integer.valueOf(this.lMW.hmi), Integer.valueOf(qVar.getType())});
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = aEc().vLw.iterator();
                while (it.hasNext()) {
                    gd gdVar = (gd) it.next();
                    x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[]{Integer.valueOf(gdVar.vJU), gdVar.vLx, gdVar.vLs, gdVar.ksY});
                    if (gdVar.vLy == null) {
                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        arp com_tencent_mm_protocal_c_arp = gdVar.vLy;
                        if (com_tencent_mm_protocal_c_arp == null) {
                            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = n.a(com_tencent_mm_protocal_c_arp.vYI);
                            String ou = bh.ou(com_tencent_mm_protocal_c_arp.wzi);
                            if (bh.ov(a) && bh.ov(ou)) {
                                x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[]{a, ou});
                            } else {
                                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[]{a});
                                ar.Hg();
                                af WO = c.EY().WO(a);
                                if (WO == null || !a.equals(WO.field_encryptUsername)) {
                                    af xVar = new com.tencent.mm.storage.x(a);
                                    xVar.cZ(com_tencent_mm_protocal_c_arp.hvy);
                                    xVar.setType(com_tencent_mm_protocal_c_arp.vXM & com_tencent_mm_protocal_c_arp.vXN);
                                    if (!bh.ov(ou)) {
                                        xVar.di(ou);
                                    } else if (WO != null && ((int) WO.gJd) > 0) {
                                        xVar.di(WO.field_encryptUsername);
                                    }
                                    xVar.gJd = WO == null ? 0 : (long) ((int) WO.gJd);
                                    xVar.dc(n.a(com_tencent_mm_protocal_c_arp.wsB));
                                    xVar.dd(n.a(com_tencent_mm_protocal_c_arp.vYw));
                                    xVar.de(n.a(com_tencent_mm_protocal_c_arp.vYx));
                                    xVar.eD(com_tencent_mm_protocal_c_arp.hvt);
                                    xVar.eG(com_tencent_mm_protocal_c_arp.vXS);
                                    xVar.db(n.a(com_tencent_mm_protocal_c_arp.wzc));
                                    xVar.eH(com_tencent_mm_protocal_c_arp.vXW);
                                    xVar.eI(com_tencent_mm_protocal_c_arp.hvx);
                                    xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_arp.hvC, com_tencent_mm_protocal_c_arp.hvu, com_tencent_mm_protocal_c_arp.hvv));
                                    xVar.dp(com_tencent_mm_protocal_c_arp.hvw);
                                    xVar.ez(com_tencent_mm_protocal_c_arp.wvf);
                                    xVar.du(com_tencent_mm_protocal_c_arp.wvg);
                                    xVar.setSource(com_tencent_mm_protocal_c_arp.vHW);
                                    xVar.ey(com_tencent_mm_protocal_c_arp.wvj);
                                    xVar.df(com_tencent_mm_protocal_c_arp.wvi);
                                    if (s.ht(com_tencent_mm_protocal_c_arp.wvh)) {
                                        xVar.dt(com_tencent_mm_protocal_c_arp.wvh);
                                    }
                                    xVar.eK((int) bh.Wo());
                                    xVar.da(n.a(com_tencent_mm_protocal_c_arp.wyH));
                                    xVar.dg(n.a(com_tencent_mm_protocal_c_arp.wyJ));
                                    xVar.dh(n.a(com_tencent_mm_protocal_c_arp.wyI));
                                    xVar.dw(com_tencent_mm_protocal_c_arp.vIO);
                                    xVar.dx(com_tencent_mm_protocal_c_arp.wzs);
                                    if (!(WO == null || bh.ou(WO.fWz).equals(bh.ou(com_tencent_mm_protocal_c_arp.wzs)))) {
                                        com.tencent.mm.bb.c.QL();
                                        com.tencent.mm.bb.c.lQ(a);
                                    }
                                    ar.Hg();
                                    c.EY().WT(a);
                                    if (bh.ov(xVar.field_username)) {
                                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = xVar.field_username;
                                        com.tencent.mm.ad.n.JQ().a(com.tencent.mm.ad.b.a(str2, com_tencent_mm_protocal_c_arp));
                                        bla com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_arp.wvl;
                                        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bla == null)) {
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bla.hvE + " " + com_tencent_mm_protocal_c_arp.vYI);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + com_tencent_mm_protocal_c_bla.hvF);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.hvG);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bla.wOs);
                                            if (com.tencent.mm.plugin.sns.b.n.qQz != null) {
                                                com.tencent.mm.plugin.sns.b.n.qQz.a(xVar.field_username, com_tencent_mm_protocal_c_bla);
                                            }
                                        }
                                        String FS = com.tencent.mm.z.q.FS();
                                        if (!(FS == null || FS.equals(str2))) {
                                            d jK = y.Mf().jK(str2);
                                            jK.field_username = str2;
                                            jK.field_brandList = com_tencent_mm_protocal_c_arp.hvD;
                                            pq pqVar = com_tencent_mm_protocal_c_arp.wvm;
                                            if (pqVar != null) {
                                                jK.field_brandFlag = pqVar.hvH;
                                                jK.field_brandInfo = pqVar.hvJ;
                                                jK.field_brandIconURL = pqVar.hvK;
                                                jK.field_extInfo = pqVar.hvI;
                                                jK.field_attrSyncVersion = null;
                                                jK.field_incrementUpdateTime = 0;
                                            }
                                            if (!y.Mf().e(jK)) {
                                                y.Mf().d(jK);
                                            }
                                            xVar.eL(jK.field_type);
                                        }
                                    }
                                    xVar.eB(com_tencent_mm_protocal_c_arp.wzr);
                                    if (!(com_tencent_mm_protocal_c_arp.wzn == null || com_tencent_mm_protocal_c_arp.wzn.vHl == null)) {
                                        xVar.dy(com_tencent_mm_protocal_c_arp.wzn.vHl.vLU);
                                        xVar.dz(com_tencent_mm_protocal_c_arp.wzn.vHl.vLV);
                                        xVar.dA(com_tencent_mm_protocal_c_arp.wzn.vHl.vLW);
                                    }
                                    if (s.hn(a)) {
                                        xVar.Ap();
                                    }
                                    if (xVar.cia()) {
                                        xVar.As();
                                    }
                                    if (bh.ov(ou)) {
                                        ar.Hg();
                                        c.EY().Q(xVar);
                                    } else {
                                        ar.Hg();
                                        c.EY().b(ou, xVar);
                                    }
                                    if (!(WO == null || (WO.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) != 0) {
                                            ar.Hg();
                                            c.Fd().Xd(xVar.field_username);
                                        } else {
                                            ar.Hg();
                                            c.Fd().Xe(xVar.field_username);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.lMW, this);
    }

    public final gc aEc() {
        if (this.lMW == null || this.lMW.hmh.hmo == null) {
            return null;
        }
        return (gc) this.lMW.hmh.hmo;
    }
}
