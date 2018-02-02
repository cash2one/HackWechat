package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public c(int i, float f, float f2, int i2, int i3, String str, String str2) {
        if (!(i == 1 || i == 2 || i == 3 || i == 4)) {
            x.e("MicroMsg.NetSceneLbsP", "OpCode Error :" + i);
        }
        a aVar = new a();
        aVar.hmj = new aoi();
        aVar.hmk = new aoj();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.hmi = JsApiScanCode.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aoi com_tencent_mm_protocal_c_aoi = (aoi) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aoi.vDW = i;
        com_tencent_mm_protocal_c_aoi.vQt = f;
        com_tencent_mm_protocal_c_aoi.vQu = f2;
        com_tencent_mm_protocal_c_aoi.wcr = i2;
        com_tencent_mm_protocal_c_aoi.wcs = str;
        com_tencent_mm_protocal_c_aoi.wct = str2;
        com_tencent_mm_protocal_c_aoi.wcu = i3;
        com_tencent_mm_protocal_c_aoi.wvs = new bdn().bj(d.oSu.bfJ());
        x.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i2 + " gpsSource:" + i3 + " mac" + str + " cell:" + str2 + " ccdLen:" + com_tencent_mm_protocal_c_aoi.wvs.wJB);
        o.a(2001, f, f2, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return JsApiScanCode.CTRL_INDEX;
    }

    public final int IS() {
        return ((aoi) this.gJQ.hmg.hmo).vDW;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aoj com_tencent_mm_protocal_c_aoj = (aoj) ((b) qVar).hmh.hmo;
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aoj.wkl.size(); i4++) {
            h hVar = new h();
            hVar.username = ((aoe) com_tencent_mm_protocal_c_aoj.wkl.get(i4)).ksU;
            hVar.fWe = ((aoe) com_tencent_mm_protocal_c_aoj.wkl.get(i4)).vHa;
            hVar.hly = ((aoe) com_tencent_mm_protocal_c_aoj.wkl.get(i4)).vUU;
            hVar.hlx = ((aoe) com_tencent_mm_protocal_c_aoj.wkl.get(i4)).vUV;
            hVar.bA(true);
            arrayList.add(hVar);
        }
        n.JQ().H(arrayList);
        if (IS() == 1 || IS() == 3 || IS() == 4) {
            if (i2 == 0 || i3 != -2001) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (com_tencent_mm_protocal_c_aoj.wvt * 1000))));
            } else {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(8210, Long.valueOf(0));
                this.gJT.a(i2, i3, str, this);
                return;
            }
        } else if (IS() == 2) {
            ar.Hg();
            com.tencent.mm.z.c.CU().set(8210, Long.valueOf(0));
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final boolean beT() {
        return ((aoj) this.gJQ.hmh.hmo).wvu == 1;
    }

    public final int beU() {
        return ((aoj) this.gJQ.hmh.hmo).wvv;
    }

    public final List<aoe> beV() {
        List<aoe> list = ((aoj) this.gJQ.hmh.hmo).wkl;
        if (list != null) {
            for (aoe com_tencent_mm_protocal_c_aoe : list) {
                ar.Hg();
                com.tencent.mm.z.c.FI().fB(com_tencent_mm_protocal_c_aoe.ksU, com_tencent_mm_protocal_c_aoe.whR);
            }
        }
        return list;
    }
}
