package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

class e$11 extends c<nz> {
    final /* synthetic */ e tik;

    e$11(e eVar) {
        this.tik = eVar;
        this.xen = nz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nz nzVar = (nz) bVar;
        if (e.a(this.tik)) {
            ar.Hg();
            aj WY = com.tencent.mm.z.c.Fd().WY(nzVar.fFS.fEJ.field_talker);
            if (WY != null) {
                int i = WY.field_unReadCount;
                f NH = a.bOt().thJ.NH(nzVar.fFS.fEJ.field_talker);
                if (i - NH.tis > 0) {
                    e.n(nzVar.fFS.fEJ.field_talker, i, false);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(NH.id));
                    a.bOt().thN.a(new i(arrayList));
                }
            }
        }
        return false;
    }
}
