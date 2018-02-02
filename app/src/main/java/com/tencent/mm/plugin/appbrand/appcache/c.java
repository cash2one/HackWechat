package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.o;
import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;

public final class c extends a<agq> {
    private final b gJQ;

    public c(String str, String str2, String str3, int i) {
        b.a aVar = new b.a();
        aVar.hmi = 1718;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_agp = new agp();
        com_tencent_mm_protocal_c_agp.fFm = str;
        com_tencent_mm_protocal_c_agp.wnX = str2;
        com_tencent_mm_protocal_c_agp.wnY = str3;
        com_tencent_mm_protocal_c_agp.vRe = i;
        if (i == 1) {
            try {
                com_tencent_mm_protocal_c_agp.wnZ = new o(g.fy(((i) f.u(i.class)).aE(str, i)).optLong("dev_key")).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", new Object[]{e});
            }
        }
        aVar.hmj = com_tencent_mm_protocal_c_agp;
        aVar.hmk = new agq();
        b JZ = aVar.JZ();
        this.gJQ = JZ;
        this.gJQ = JZ;
    }
}
