package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.protocal.c.cbf;
import com.tencent.mm.sdk.platformtools.bh;

final class l extends a<cbf> {
    final b gJQ;

    l(String str, String str2) {
        com.tencent.mm.bq.b bVar;
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_cbd = new cbd();
        com_tencent_mm_protocal_c_cbd.xaw = str;
        if (bh.ov(str)) {
            WxaAttributes f = f.Zh().f(str2, "syncVersion");
            bVar = new com.tencent.mm.bq.b((f == null ? "" : bh.ou(f.field_syncVersion)).getBytes());
        } else {
            bVar = r.qX(str);
        }
        com_tencent_mm_protocal_c_cbd.vNh = bVar;
        com_tencent_mm_protocal_c_cbd.xax = str2;
        aVar.hmj = com_tencent_mm_protocal_c_cbd;
        aVar.hmk = new cbf();
        aVar.hmi = 1151;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        b JZ = aVar.JZ();
        this.gJQ = JZ;
        this.gJQ = JZ;
    }
}
