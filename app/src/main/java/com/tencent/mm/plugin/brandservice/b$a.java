package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.g.a.oy;
import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class b$a extends c<oy> {
    public b$a() {
        this.xen = oy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oy oyVar = (oy) bVar;
        if (oyVar instanceof oy) {
            if (!(oyVar.fGQ == null || bh.ov(oyVar.fGQ.fFh) || oyVar.fGQ.fGR == null)) {
                ar.CG().a(new l(oyVar.fGQ.fFh, oyVar.fGQ.fGR), 0);
            }
            return true;
        }
        x.f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
        return false;
    }
}
