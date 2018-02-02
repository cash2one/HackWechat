package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.protocal.c.gi;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class k extends a<gj> {
    k(List<String> list, a aVar) {
        x.i("MicroMsg.AppBrand.CgiBatchWxaAttrSync", "create sync request, list_size %d, scene %s(%d)", new Object[]{Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.ordinal())});
        com.tencent.mm.bq.a giVar = new gi();
        giVar.rYW = aVar.ordinal();
        for (String str : list) {
            if (!bh.ov(str)) {
                cbg com_tencent_mm_protocal_c_cbg = new cbg();
                com_tencent_mm_protocal_c_cbg.xaw = str;
                com_tencent_mm_protocal_c_cbg.vNh = r.qX(str);
                giVar.vLD.add(com_tencent_mm_protocal_c_cbg);
            }
        }
        b.a aVar2 = new b.a();
        aVar2.hmj = giVar;
        aVar2.hmk = new gj();
        aVar2.hmi = 1192;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.gJQ = aVar2.JZ();
    }
}
