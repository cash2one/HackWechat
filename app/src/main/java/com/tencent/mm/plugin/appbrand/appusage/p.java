package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.aiv;

class p extends a<aiv> {
    p(int i, int i2, int i3, int i4) {
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_aiu = new aiu();
        com_tencent_mm_protocal_c_aiu.aAk = i;
        com_tencent_mm_protocal_c_aiu.condition = i2;
        com_tencent_mm_protocal_c_aiu.wqp = i3;
        com_tencent_mm_protocal_c_aiu.wqq = i4;
        aVar.hmj = com_tencent_mm_protocal_c_aiu;
        aVar.hmk = new aiv();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        aVar.hmi = 1148;
        this.gJQ = aVar.JZ();
    }
}
