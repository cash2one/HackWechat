package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.d.a;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.z.ar;

class b$b extends d {
    final /* synthetic */ b thU;
    private byj thV;

    public b$b(b bVar, byj com_tencent_mm_protocal_c_byj) {
        this.thU = bVar;
        this.thV = com_tencent_mm_protocal_c_byj;
    }

    public final void execute() {
        ar.CG().a(1091, this.thU);
        ar.CG().a(new a(this.thV.wYz, "gh_43f2581f6fd6"), 0);
    }

    public final String getName() {
        return "RegisterDeviceTask";
    }
}
