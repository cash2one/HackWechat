package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.appbrand.appusage.h.c;
import com.tencent.mm.protocal.c.bqz;
import com.tencent.mm.protocal.c.bra;

class h$c$1 implements a {
    int count = 0;
    final /* synthetic */ c iJD;

    h$c$1(c cVar) {
        this.iJD = cVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        com.tencent.mm.plugin.appbrand.q.c.bk(this);
        com.tencent.mm.modelgeo.c.OP().c(this);
        int i2 = this.count;
        this.count = i2 + 1;
        if (i2 <= 0 && z) {
            b.a aVar = new b.a();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
            aVar.hmi = 1154;
            aVar.hmk = new bra();
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_bqz = new bqz();
            com_tencent_mm_protocal_c_bqz.latitude = (double) f2;
            com_tencent_mm_protocal_c_bqz.longitude = (double) f;
            com_tencent_mm_protocal_c_bqz.wSr = d2;
            aVar.hmj = com_tencent_mm_protocal_c_bqz;
            u.a(aVar.JZ(), new 1(this, f, f2, d2), true);
        }
        return true;
    }
}
