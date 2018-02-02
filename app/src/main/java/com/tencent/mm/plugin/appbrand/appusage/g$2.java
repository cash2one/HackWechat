package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.aip;

class g$2 implements a {
    final /* synthetic */ PBool iJn;
    final /* synthetic */ PBool iJo;
    private int iJp = 0;

    g$2(PBool pBool, PBool pBool2) {
        this.iJo = pBool;
        this.iJn = pBool2;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        c.bk(this);
        com.tencent.mm.modelgeo.c.OP().c(this);
        int i2 = this.iJp + 1;
        this.iJp = i2;
        if (i2 > 1 || this.iJo.value) {
            return false;
        }
        this.iJn.value = true;
        if (z) {
            b.a aVar = new b.a();
            aVar.hmi = 1056;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_aio = new aio();
            com_tencent_mm_protocal_c_aio.wpN = (double) f;
            com_tencent_mm_protocal_c_aio.wpO = (double) f2;
            com_tencent_mm_protocal_c_aio.wpQ = !g.aaO();
            aVar.hmj = com_tencent_mm_protocal_c_aio;
            aVar.hmk = new aip();
            u.a(aVar.JZ(), new 1(this), true);
            return false;
        }
        g.a(null);
        return false;
    }
}
