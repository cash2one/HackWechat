package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.m.f.a;
import com.tencent.mm.plugin.appbrand.m.f.b;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.sdk.f.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class t implements f {
    public final a abg() {
        a aVar = new a();
        aVar.hiv = new ArrayList(0);
        aVar.jJf = -1;
        aVar.fyY = "";
        if (!g.Dh().gPy || !a.aaB()) {
            return aVar;
        }
        int i;
        afq abe = o.abe();
        a aVar2 = new a();
        aVar2.fyY = abe == null ? null : abe.nGK;
        aVar2.jJf = abe == null ? 0 : abe.wny;
        if (abe == null) {
            Iterator 1 = new 1(this, com.tencent.mm.plugin.appbrand.app.f.Zm().a(new String[]{"brandId", "versionType"}, 4, 0));
            i = 4;
        } else {
            2 2 = new 2(this, abe);
            i = abe.wnx.size();
            e.post(new 3(this, abe), "BatchSyncWxaAttrBySearchShowOut");
            Object obj = 2;
        }
        aVar2.hiv = new ArrayList(i);
        while (1.hasNext()) {
            Object[] objArr = (Object[]) 1.next();
            WxaAttributes e = com.tencent.mm.plugin.appbrand.app.f.Zh().e((String) objArr[0], "nickname", "brandIconURL");
            if (e != null) {
                b bVar = new b();
                bVar.username = (String) objArr[0];
                bVar.iKd = ((Integer) objArr[1]).intValue();
                bVar.fIm = ((Integer) objArr[2]).intValue();
                bVar.fpL = e.field_nickname;
                bVar.iKm = e.field_brandIconURL;
                aVar2.hiv.add(bVar);
            }
        }
        o.jG(o.a.iKh);
        return aVar2;
    }
}
