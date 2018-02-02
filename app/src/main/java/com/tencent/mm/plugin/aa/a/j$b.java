package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class j$b implements e<Boolean, d<String, Integer, String>> {
    final /* synthetic */ j igC;

    public j$b(j jVar) {
        this.igC = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        i iVar = this.igC.igz;
        String str = (String) dVar.get(0);
        int intValue = ((Integer) dVar.get(1)).intValue();
        String str2 = (String) dVar.get(2);
        iVar.hmc = g.czQ();
        if (bh.ov(str)) {
            iVar.hmc.cl(Boolean.valueOf(false));
        } else {
            k eVar = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(eVar, 0);
            x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
            iVar.hmc = g.czX();
        }
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
