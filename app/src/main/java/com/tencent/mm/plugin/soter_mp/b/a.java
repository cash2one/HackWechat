package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.hj$b;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<hj> {
    public a() {
        this.xen = hj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 1;
        hj hjVar = (hj) bVar;
        x.i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", Integer.valueOf(hjVar.fxE.fxG));
        if (hjVar.fxE.fxG == 1 && h.bCT()) {
            x.i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", Boolean.valueOf(com.tencent.d.a.a.id(ac.getContext())));
            hj$b com_tencent_mm_g_a_hj_b = hjVar.fxF;
            if (!com.tencent.d.a.a.id(ac.getContext())) {
                i = 0;
            }
            com_tencent_mm_g_a_hj_b.fxH = i;
        } else {
            x.w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            hjVar.fxF.fxH = -1;
        }
        return false;
    }
}
