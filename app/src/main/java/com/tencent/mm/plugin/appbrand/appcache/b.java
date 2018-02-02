package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ae.a;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.ain;

public final class b extends a<ain> {
    public final com.tencent.mm.ae.b gJQ;

    public b(String str, int i, String str2, int i2, int i3) {
        aim com_tencent_mm_protocal_c_aim = new aim();
        com_tencent_mm_protocal_c_aim.vOv = i;
        com_tencent_mm_protocal_c_aim.fFm = str;
        com_tencent_mm_protocal_c_aim.wpJ = str2;
        com_tencent_mm_protocal_c_aim.wpK = i2;
        com_tencent_mm_protocal_c_aim.wpL = i3;
        this(com_tencent_mm_protocal_c_aim);
    }

    public b(aim com_tencent_mm_protocal_c_aim) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 1139;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        aVar.hmj = com_tencent_mm_protocal_c_aim;
        aVar.hmk = new ain();
        com.tencent.mm.ae.b JZ = aVar.JZ();
        this.gJQ = JZ;
        this.gJQ = JZ;
    }

    public b(String str, int i, String str2, int i2) {
        this(str, i, str2, i2, 0);
    }
}
