package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bvb;
import com.tencent.mm.protocal.c.bvc;
import com.tencent.mm.protocal.c.bvd;

public final class l extends n<bvc, bvd> {
    public l(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hmj = new bvc();
        aVar.hmk = new bvd();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        aVar.hmi = 320;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bvc com_tencent_mm_protocal_c_bvc = (bvc) this.gJQ.hmg.hmo;
        bvb com_tencent_mm_protocal_c_bvb = new bvb();
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(str);
        com_tencent_mm_protocal_c_bvb.wQf = com_tencent_mm_protocal_c_bdo;
        bvb com_tencent_mm_protocal_c_bvb2 = new bvb();
        bdo com_tencent_mm_protocal_c_bdo2 = new bdo();
        com_tencent_mm_protocal_c_bdo2.UA(str2);
        com_tencent_mm_protocal_c_bvb2.wQf = com_tencent_mm_protocal_c_bdo2;
        bvb com_tencent_mm_protocal_c_bvb3 = new bvb();
        bdo com_tencent_mm_protocal_c_bdo3 = new bdo();
        com_tencent_mm_protocal_c_bdo3.UA(str3);
        com_tencent_mm_protocal_c_bvb3.wQf = com_tencent_mm_protocal_c_bdo3;
        bvb com_tencent_mm_protocal_c_bvb4 = new bvb();
        bdo com_tencent_mm_protocal_c_bdo4 = new bdo();
        com_tencent_mm_protocal_c_bdo4.UA(str4);
        com_tencent_mm_protocal_c_bvb4.wQf = com_tencent_mm_protocal_c_bdo4;
        bvb com_tencent_mm_protocal_c_bvb5 = new bvb();
        bdo com_tencent_mm_protocal_c_bdo5 = new bdo();
        com_tencent_mm_protocal_c_bdo5.UA(str5);
        com_tencent_mm_protocal_c_bvb5.wQf = com_tencent_mm_protocal_c_bdo5;
        com_tencent_mm_protocal_c_bvc.wVk = com_tencent_mm_protocal_c_bvb;
        com_tencent_mm_protocal_c_bvc.wWE = com_tencent_mm_protocal_c_bvb2;
        com_tencent_mm_protocal_c_bvc.wWD = com_tencent_mm_protocal_c_bvb3;
        com_tencent_mm_protocal_c_bvc.wWF = com_tencent_mm_protocal_c_bvb4;
        com_tencent_mm_protocal_c_bvc.wWG = com_tencent_mm_protocal_c_bvb5;
    }

    public final int getType() {
        return 320;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
