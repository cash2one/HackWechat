package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class j$a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
    final /* synthetic */ j igC;

    public j$a(j jVar) {
        this.igC = jVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        i iVar = this.igC.igz;
        String str = (String) eVar.get(0);
        int intValue = ((Integer) eVar.get(1)).intValue();
        String str2 = (String) eVar.get(2);
        long longValue = ((Long) eVar.get(3)).longValue();
        iVar.hmc = g.czQ();
        iVar.fqm = longValue;
        if (bh.ov(str)) {
            iVar.hmc.cl(Boolean.valueOf(false));
        } else {
            k eVar2 = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(eVar2, 0);
            x.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", new Object[]{str, Integer.valueOf(intValue)});
            iVar.hmc = g.czX();
        }
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
