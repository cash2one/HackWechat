package com.tencent.mm.modelappbrand;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.hw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.bxj;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class m extends a implements k {
    private e gOB;
    private final b hjD;
    private bxk hjE;
    private d hjF;

    public m(d dVar) {
        this.hjF = dVar;
        this.tjL = dVar.fDl;
        this.tjM = dVar.fod;
        this.wn = dVar.offset;
        this.irz = dVar.scene;
        this.tjO = dVar.tkh;
        b.a aVar = new b.a();
        aVar.hmj = new bxj();
        aVar.hmk = new bxk();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        aVar.hmi = 1162;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hjD = aVar.JZ();
        bxj com_tencent_mm_protocal_c_bxj = (bxj) this.hjD.hmg.hmo;
        aoh Je = Je();
        com_tencent_mm_protocal_c_bxj.ktN = dVar.hKY;
        com_tencent_mm_protocal_c_bxj.wkq = dVar.fod;
        com_tencent_mm_protocal_c_bxj.vNW = dVar.offset;
        com_tencent_mm_protocal_c_bxj.vPs = dVar.lEK;
        com_tencent_mm_protocal_c_bxj.wYe = dVar.tjW;
        com.tencent.mm.sdk.b.b hwVar = new hw();
        com.tencent.mm.sdk.b.a.xef.m(hwVar);
        com_tencent_mm_protocal_c_bxj.wYd = hwVar.fyo.fyp;
        if (Je != null) {
            com_tencent_mm_protocal_c_bxj.wYf = (double) Je.vQt;
            com_tencent_mm_protocal_c_bxj.wYg = (double) Je.vQu;
        }
        com_tencent_mm_protocal_c_bxj.wYh = b.hjx;
        com_tencent_mm_protocal_c_bxj.wYk = dVar.tjS;
        com_tencent_mm_protocal_c_bxj.wYl = dVar.tjX;
        com_tencent_mm_protocal_c_bxj.wYm = dVar.tjY;
        com_tencent_mm_protocal_c_bxj.wYi = b.hjy;
        com_tencent_mm_protocal_c_bxj.wFj = dVar.mLr;
        x.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", new Object[]{com_tencent_mm_protocal_c_bxj.wYh, com_tencent_mm_protocal_c_bxj.wYi, Double.valueOf(com_tencent_mm_protocal_c_bxj.wYf), Double.valueOf(com_tencent_mm_protocal_c_bxj.wYg)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.hjE = (bxk) this.hjD.hmh.hmo;
        if (this.hjE != null) {
            x.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", new Object[]{this.hjE.vOe});
        }
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1162;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }

    public final String Jc() {
        return this.hjE != null ? this.hjE.vOe : "";
    }

    public final int Jd() {
        return this.hjE != null ? this.hjE.wYn : 0;
    }

    private static aoh Je() {
        try {
            ar.Hg();
            String str = (String) c.CU().get(67591, null);
            if (str != null) {
                aoh com_tencent_mm_protocal_c_aoh = new aoh();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aoh.wcr = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aoh.wcu = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aoh.vQu = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aoh.vQt = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aoh.vQu), Float.valueOf(com_tencent_mm_protocal_c_aoh.vQt)});
                return com_tencent_mm_protocal_c_aoh;
            }
            x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
