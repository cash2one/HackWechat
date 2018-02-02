package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.protocal.c.bvb;

public final class c extends n<bua, bub> {
    public c(int i, long j, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hmj = new bua();
        aVar.hmk = new bub();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        this.gJQ = aVar.JZ();
        bua com_tencent_mm_protocal_c_bua = (bua) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bua.wbh = i;
        com_tencent_mm_protocal_c_bua.wbi = j;
        com_tencent_mm_protocal_c_bua.nko = str;
        com_tencent_mm_protocal_c_bua.wFq = i2;
        bvb com_tencent_mm_protocal_c_bvb = new bvb();
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(str2);
        com_tencent_mm_protocal_c_bvb.wQf = com_tencent_mm_protocal_c_bdo;
        com_tencent_mm_protocal_c_bua.wVk = com_tencent_mm_protocal_c_bvb;
        com_tencent_mm_protocal_c_bua.wUq = System.currentTimeMillis();
    }

    public final int bHK() {
        bua com_tencent_mm_protocal_c_bua = (bua) bHO();
        if (com_tencent_mm_protocal_c_bua.wbh == 0 && com_tencent_mm_protocal_c_bua.wFq == 0) {
            return -1;
        }
        return 0;
    }

    public final int getType() {
        return 171;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
