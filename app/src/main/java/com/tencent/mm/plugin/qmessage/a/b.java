package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.b.af;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.fr;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b extends k implements com.tencent.mm.network.k {
    private e gJT;
    private Set<String> pnr;

    public b(Set<String> set) {
        Assert.assertTrue(true);
        this.pnr = set;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        List<String> linkedList = new LinkedList();
        for (String add : this.pnr) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", g.zh() + "doScene reqSize ==0");
            return -1;
        }
        a aVar = new a();
        aVar.hmj = new fr();
        aVar.hmk = new fs();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
        aVar.hml = 28;
        aVar.hmm = 1000000028;
        q JZ = aVar.JZ();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(n.os(add2));
        }
        ((fr) JZ.hmg.hmo).vLm = linkedList2;
        ((fr) JZ.hmg.hmo).vLl = 1;
        ((fr) JZ.hmg.hmo).ksO = linkedList2.size();
        return a(eVar, JZ, this);
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
    }

    protected final int Bh() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            if (h(qVar) && this.pnr.size() > 0) {
                a(this.hmA, this.gJT);
            }
            x.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.pnr.size());
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    private boolean h(q qVar) {
        fs fsVar = (fs) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        if (fsVar == null) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            return false;
        } else if (qVar.Hp().vBp == 1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            return false;
        } else if (qVar.Hp().vBp == -1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            return true;
        } else {
            List list = fsVar.vLn;
            if (list == null) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                oy oyVar;
                boolean z;
                try {
                    oyVar = (oy) new oy().aF(n.a((bdn) list.get(i)));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    oyVar = null;
                }
                if (oyVar == null || oyVar.ksU == null) {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.pnr.contains(oyVar.ksU)) {
                    this.pnr.remove(oyVar.ksU);
                    ar.Hg();
                    af WO = c.EY().WO(oyVar.ksU);
                    if (WO == null || ((int) WO.gJd) == 0) {
                        x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        WO.setUsername(oyVar.ksU);
                        WO.cZ(oyVar.hvy);
                        WO.setType(oyVar.vXM & oyVar.vXN);
                        WO.dc(oyVar.kub);
                        WO.dd(oyVar.vXK);
                        WO.de(oyVar.vXL);
                        WO.eD(oyVar.hvt);
                        WO.da(oyVar.vXO);
                        WO.dg(oyVar.vXR);
                        WO.dh(oyVar.vXQ);
                        WO.eG(oyVar.vXS);
                        WO.db(oyVar.vXV);
                        WO.eH(oyVar.vXW);
                        ar.Hg();
                        if (c.EY().a(WO.field_username, WO) == -1) {
                            x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (com.tencent.mm.storage.x.Wz(oyVar.ksU)) {
                            d HD = g.bjY().HD(oyVar.ksU);
                            if (HD == null || bh.ou(HD.getUsername()).length() <= 0) {
                                x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                HD.extInfo = oyVar.nkB;
                                HD.pnu = (long) oyVar.vXY;
                                HD.pnv = (long) oyVar.vXZ;
                                HD.fDt = 52;
                                if (!g.bjY().a(oyVar.ksU, HD)) {
                                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (com.tencent.mm.storage.x.Wx(oyVar.ksU)) {
                            com.tencent.mm.sdk.b.b rfVar = new rf();
                            rfVar.fIV.opType = 0;
                            rfVar.fIV.fDC = oyVar.ksU;
                            rfVar.fIV.fDD = oyVar.vXY;
                            rfVar.fIV.fDE = oyVar.vXP;
                            com.tencent.mm.sdk.b.a.xef.m(rfVar);
                        }
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
    }
}
